package com.oryx.core.dashboard.tb.pageobjects;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.testbench.elements.WindowElement;
import org.openqa.selenium.WebDriver;

public class TBDashboardEdit extends TestBenchTestCase {
    private final WindowElement scope;

    public TBDashboardEdit(WebDriver driver) {
        setDriver(driver);
        scope = $(WindowElement.class).caption("Edit Dashboard").first();
    }

    public void setDashboardTitle(String newName) {
        scope.$(TextFieldElement.class).first().setValue(newName);
    }

    public void save() {
        scope.$(ButtonElement.class).caption("Save").first().click();
    }

}
