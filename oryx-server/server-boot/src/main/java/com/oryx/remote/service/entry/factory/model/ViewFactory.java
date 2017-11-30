package com.oryx.remote.service.entry.factory.model;

import com.oryx.core.view.system.ose.UserView;

public class ViewFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oryx.remote.webservice.element.model
     */
    public ViewFactory() {
    }

    /**
     * Create an instance of {@link UserView }
     */
    public UserView createUserView() {
        return new UserView();
    }

}