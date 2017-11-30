package com.oryx.core.security;

import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.parameter.IServerParameterNames;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by smbarki on 24/08/2017.
 */
public interface IUserProvider {
    public static Map<UUID, XmlUser> connectedUsersIdMap = new HashMap<>();
    public static Map<String, UUID> connectedUsersSessionTokenMap = new HashMap<>();
    public static Map<String, LocalDateTime> UsersSessionLastActivityMap = new HashMap<>();

    public static UUID getUuidBySessionToken(String sessionToken) {
        return connectedUsersSessionTokenMap.get(sessionToken);
    }

    public static XmlUser getUserById(UUID id) {
        return connectedUsersIdMap.get(id);
    }

    public static XmlUser getUserBySessionToken(String sessionToken) {
        return getUserById(getUuidBySessionToken(sessionToken));
    }

    public static void addUser(XmlUser user, String sessionToken) {
        if (user != null && sessionToken != null) {
            if (connectedUsersIdMap.containsKey(UUID.fromString(user.getId()))) {
                connectedUsersIdMap.remove(UUID.fromString(user.getId()));
                for (String strToken : connectedUsersSessionTokenMap.keySet()) {
                    if (connectedUsersSessionTokenMap.get(strToken).equals(user.getId())) {
                        connectedUsersSessionTokenMap.remove(strToken);
                    }
                }
            }

            connectedUsersIdMap.put(UUID.fromString(user.getId()), user);
            connectedUsersSessionTokenMap.put(sessionToken, UUID.fromString(user.getId()));
            UsersSessionLastActivityMap.put(sessionToken, LocalDateTime.now());
        }
    }

    public static boolean isConnected(String sessionToken) {
        if (getUserById(getUuidBySessionToken(sessionToken)) != null) {
            String allowedInactivityTime_min = CommonServiceHelper.getParameterService().getValue(IServerParameterNames.ALLOWED_INACTIVITY_TIME);
            long allowedInactivityTime = 15;
            if (allowedInactivityTime_min != null) {
                allowedInactivityTime = Long.valueOf(allowedInactivityTime_min);
            }

            if (LocalDateTime.now().minusMinutes(allowedInactivityTime).isBefore(UsersSessionLastActivityMap.get(sessionToken))) {
                UsersSessionLastActivityMap.put(sessionToken, LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    public static boolean isConnected(UUID id) {
        return connectedUsersIdMap.get(id) != null;
    }
}
