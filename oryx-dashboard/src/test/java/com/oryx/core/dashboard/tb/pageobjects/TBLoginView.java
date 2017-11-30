package com.oryx.core.dashboard.tb.pageobjects;

import com.vaadin.testbench.ElementQuery;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import org.openqa.selenium.WebDriver;

public class TBLoginView extends TestBenchTestCase {

    public TBLoginView(WebDriver driver) {
        setDriver(driver);
    }

    public TBMainView login() {
        getLoginButton().first().click();
        return new TBMainView(driver);
    }

    public boolean isDisplayed() {
        return getLoginButton().exists();
    }

    private ElementQuery<ButtonElement> getLoginButton() {
        return $(ButtonElement.class).caption("Sign In");
    }
}
