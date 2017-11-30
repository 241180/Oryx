package com.oryx.remote.service.entry.endpoint.view.bu.health;

import com.oryx.core.binder.delegate.CrudDelegateHelper;
import com.oryx.remote.service.entry.endpoint.view.namespace.TargetNameSpace;
import com.oryx.remote.webservice.element._enum.XmlEnumServiceOperation;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;
import com.oryx.remote.webservices.service.patientviewservice.ViewRequest;
import com.oryx.remote.webservices.service.patientviewservice.ViewResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

/**
 * The Class patientViewService.
 */
@Endpoint
public class PatientViewServiceEndpoint {

    final static Logger logger = Logger.getLogger(PatientViewServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.VIEW_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_PATIENT_VIEW)
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

                }
                break;
                case UPDATE: {

                }
                break;
                case DELETE: {

                }
                break;
            }

            if (request.getRequest().getOperation() == XmlEnumServiceOperation.FETCH_BY_CRITERIA) {
                Iterator<XmlPatientView> it = request.getObject().iterator();
                while (it.hasNext()) {
                    XmlPatientView xmlPatientView = it.next();
                    XmlPatient xmlpatient = new XmlPatient();
                    xmlpatient.setEmail(xmlPatientView.getEmail());
                    XmlPerson xmlPerson = new XmlPerson();
                    xmlPerson.setFirstName(xmlPatientView.getFirstName());
                    xmlPerson.setLastName(xmlPatientView.getLastName());
                    xmlpatient.setPerson(xmlPerson);
                    List<XmlPatient> patients = CrudDelegateHelper.findByCriteria(xmlpatient);
                    if (patients != null && !patients.isEmpty()) {
                        for (XmlPatient patient : patients) {
                            xmlPatientView = new XmlPatientView();
                            xmlPatientView.setPatientCode(patient.getPatientCode());
                            xmlPatientView.setEmail(patient.getEmail());
                            if (patient.getPerson() != null) {
                                xmlPatientView.setFirstName(patient.getPerson().getFirstName());
                                xmlPatientView.setLastName(patient.getPerson().getLastName());
                            }

                            viewResponse.getObject().add(xmlPatientView);
                        }
                    }
                }
            } else if (request.getRequest().getOperation() == XmlEnumServiceOperation.FETCH_ALL) {
                List<XmlPatient> patients = CrudDelegateHelper.findAll(XmlPatient.class);
                if (patients != null && !patients.isEmpty()) {
                    for (XmlPatient patient : patients) {
                        XmlPatientView xmlPatientView = new XmlPatientView();
                        xmlPatientView.setPatientCode(patient.getPatientCode());
                        xmlPatientView.setEmail(patient.getEmail());
                        if (patient.getPerson() != null) {
                            xmlPatientView.setFirstName(patient.getPerson().getFirstName());
                            xmlPatientView.setLastName(patient.getPerson().getLastName());
                        }

                        viewResponse.getObject().add(xmlPatientView);
                    }
                }
            } else if (request.getRequest().getOperation() == XmlEnumServiceOperation.CREATE) {
                Iterator<XmlPatientView> it = request.getObject().iterator();
                while (it.hasNext()) {
                    XmlPatientView xmlPatientView = it.next();
                    //xmlPatientView.getPatientCode(xmlPatientView.getPatientCode());

                    //CrudDelegateHelper.create(xmlPatientView.getPatient());
                }
            } else if (request.getRequest().getOperation() == XmlEnumServiceOperation.UPDATE) {
                Iterator<XmlPatientView> it = request.getObject().iterator();
                while (it.hasNext()) {
                    XmlPatientView xmlPatientView = it.next();
                    //xmlPatientView.getPatient().setPerson(xmlPatientView.getPerson());
                    //xmlPatientView.getPatient().getRoleSet().addAll(xmlPatientView.getPatient().getRoleSet());

                    //CrudDelegateHelper.update(xmlPatientView.getPatient());
                }
            } else if (request.getRequest().getOperation() == XmlEnumServiceOperation.DELETE) {
                Iterator<XmlPatientView> it = request.getObject().iterator();
                while (it.hasNext()) {
                    XmlPatientView xmlPatientView = it.next();

                    //CrudDelegateHelper.delete(XmlPatient.class, UUID.fromString(xmlPatientView.getPatient().getId()));
                }
            }
        } catch (IllegalAccessException e) {
            viewResponse.getResponse().setMsg(e.getCause().getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            viewResponse.getResponse().setMsg(e.getCause().getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewResponse;
    }
}