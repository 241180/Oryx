package com.oryx.core.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlAuthentification", namespace = "http://operation.element.webservice.remote.oryx.com")
public class Authentification {
    private String accesskey;
    private String domainCode;
}
