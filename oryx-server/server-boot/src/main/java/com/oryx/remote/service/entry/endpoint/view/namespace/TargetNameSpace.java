package com.oryx.remote.service.entry.endpoint.view.namespace;

/**
 * Created by 241180 on 06/03/2017.
 */
public interface TargetNameSpace {
    static final String VIEW_REQUEST_LOCAL_PORT = "viewRequest";

    static final String TARGET_NAMESPACE_BASE = "http://com/oryx/remote/webservices/service/";

    static final String TARGET_NAMESPACE_USER_VIEW = TARGET_NAMESPACE_BASE + "userviewservice";
    static final String TARGET_NAMESPACE_PATIENT_VIEW = TARGET_NAMESPACE_BASE + "patientviewservice";
}
