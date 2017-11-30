package com.oryx.core.dashboard.domain;

import com.oryx.remote.webservice.element._enum.XmlEnumGender;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;

public final class User {
    private String login;
    private String password;
    private String domain;
    private String role;
    private String firstName;
    private String lastName;
    private String title;
    private boolean male;
    private String email;
    private String location;
    private String phone;
    private Integer newsletterSubscription;
    private String website;
    private String bio;

    public User() {
    }

    public User(XmlUser xmlUser) {
        this.login = xmlUser.getUserLogin();
        this.password = xmlUser.getUserPassword();
        this.domain = xmlUser.getDomainScope();
        this.role = xmlUser.getRole().name();
        this.email = xmlUser.getEmail();
        if (xmlUser.getPerson() != null) {
            this.firstName = xmlUser.getPerson().getFirstName();
            this.lastName = xmlUser.getPerson().getLastName();
            //this.title;
            this.male = xmlUser.getPerson().getGender() == XmlEnumGender.MALE ? true : false;

            if (xmlUser.getPerson().getAdressSet() != null && xmlUser.getPerson().getAdressSet().size() > 0) {
                this.location = xmlUser.getPerson().getAdressSet().get(0).getStreet();
            }
        }

        //this.phone;
        //this.newsletterSubscription;
        //this.website;
        //this.bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public Integer getNewsletterSubscription() {
        return newsletterSubscription;
    }

    public void setNewsletterSubscription(final Integer newsletterSubscription) {
        this.newsletterSubscription = newsletterSubscription;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(final String website) {
        this.website = website;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(final String bio) {
        this.bio = bio;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(final boolean male) {
        this.male = male;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
