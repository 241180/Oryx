package com.oryx.remote.service.entry.endpoint.view.system.ose;

import com.oryx.core.binder.delegate.CrudDelegateHelper;
import com.oryx.remote.service.entry.endpoint.view.namespace.TargetNameSpace;
import com.oryx.remote.webservice.element._enum.XmlEnumContact;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.oryx.remote.webservice.element.model.system.ref.XmlAdress;
import com.oryx.remote.webservice.element.model.system.ref.XmlContact;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;
import com.oryx.remote.webservices.service.userviewservice.ViewRequest;
import com.oryx.remote.webservices.service.userviewservice.ViewResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Iterator;

/**
 * The Class UserViewService.
 */
@Endpoint
public class UserViewServiceEndpoint {

    final static Logger logger = Logger.getLogger(UserViewServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.VIEW_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_USER_VIEW)
    public
    @ResponsePayload
    ViewResponse ViewOperation(@RequestPayload ViewRequest request) {
        ViewResponse viewResponse = new ViewResponse();
        try {

            switch (request.getRequest().getOperation()) {
                case FETCH_BY_CRITERIA: {

                }
                break;
                case FETCH_ALL: {

                }
                break;
                case FETCH_BY_ID: {

                }
                break;
                case CREATE: {
                    Iterator<XmlUserView> it = request.getObject().iterator();
                    while (it.hasNext()) {
                        XmlUserView xmlUserView = it.next();
                        CrudDelegateHelper.create(getUser(xmlUserView));
                    }
                }
                break;
                case UPDATE: {

                }
                break;
                case DELETE: {

                }
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewResponse;
    }

    public XmlAdress getAdress(XmlUserView xmlUserView) {
        XmlAdress adress = new XmlAdress();

        adress.setCountryId(xmlUserView.getAdressCountryId());
        adress.setStateId(xmlUserView.getAdressCityId());
        adress.setStreet(xmlUserView.getAdressStreet());

        return adress;
    }

    public XmlUser getUser(XmlUserView xmlUserView) {
        XmlUser user = new XmlUser();

        user.setEmail(xmlUserView.getEmail());
        user.setUserLogin(xmlUserView.getUserLogin());
        user.setUserPassword(xmlUserView.getUserPassword());
        //user.setStartDate(xmlUserView.startDate);
        //user.setEndDate(xmlUserView.endDate);
        user.setLanguage(xmlUserView.getLanguage());
        user.setRole(xmlUserView.getRole());
        user.setStatus(xmlUserView.getStatus());

        user.setPerson(getPerson(xmlUserView));

        return user;
    }

    public XmlPerson getPerson(XmlUserView xmlUserView) {
        XmlPerson person = new XmlPerson();

        person.setDefaultUid(xmlUserView.getDefaultUid());
        person.setFirstName(xmlUserView.getFirstName());
        person.setLastName(xmlUserView.getLastName());
        person.setDefaultPhoneNumber(xmlUserView.getPhoneNumber1());
        person.setCivility(xmlUserView.getCivility());
        person.setGender(xmlUserView.getGender());
        person.setLanguage(xmlUserView.getLanguage());
        //person.setBirthDate(xmlUserView.birthDate);
        person.setBirthPlaceId(xmlUserView.getBirthCityId());
        person.getAdressSet().add(getAdress(xmlUserView));

        XmlContact contact = new XmlContact();
        contact.setContactType(XmlEnumContact.PHONE);
        contact.setValue(xmlUserView.getPhoneNumber1());
        person.getContactSet().add(contact);

        contact = new XmlContact();
        contact.setContactType(XmlEnumContact.PHONE);
        contact.setValue(xmlUserView.getPhoneNumber2());
        person.getContactSet().add(contact);

        contact = new XmlContact();
        contact.setContactType(XmlEnumContact.EMAIL);
        contact.setValue(xmlUserView.getEmail());
        person.getContactSet().add(contact);

        return person;
    }
}