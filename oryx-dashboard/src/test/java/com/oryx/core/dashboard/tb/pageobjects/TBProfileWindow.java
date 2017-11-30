package com.oryx.core.dashboard.tb.pageobjects;

import com.oryx.core.dashboard.component.ProfilePreferencesWindow;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.testbench.elements.WindowElement;
import org.openqa.selenium.WebDriver;

public class TBProfileWindow extends TestBenchTestCase {

    private final WindowElement scope;

    public TBProfileWindow(WebDriver driver) {
        setDriver(driver);
        scope = $(WindowElement.class).id(ProfilePreferencesWindow.ID);
    }

    public void setName(String firstName, String lastName) {
        scope.$(TextFieldElement.class).caption("First Name").first()
                .setValue(firstName);
        scope.$(TextFieldElement.class).caption("Last Name").first()
                .setValue(lastName);
    }

    public void commit() {
        scope.$(ButtonElement.class).caption("OK").first().click();
    }

}
