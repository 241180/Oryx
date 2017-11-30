package com.oryx.core.dashboard;

import com.google.common.eventbus.Subscribe;
import com.oryx.core.bundle.loader.IBundleLoader;
import com.oryx.core.dashboard.data.DataProvider;
import com.oryx.core.dashboard.data.dummy.DummyDataProvider;
import com.oryx.core.dashboard.domain.User;
import com.oryx.core.dashboard.event.DashboardEvent.BrowserResizeEvent;
import com.oryx.core.dashboard.event.DashboardEvent.CloseOpenWindowsEvent;
import com.oryx.core.dashboard.event.DashboardEvent.UserLoggedOutEvent;
import com.oryx.core.dashboard.event.DashboardEvent.UserLoginRequestedEvent;
import com.oryx.core.dashboard.event.DashboardEventBus;
import com.oryx.core.dashboard.view.LoginView;
import com.oryx.core.dashboard.view.MainView;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.module.IModule;
import com.oryx.core.module.annotation.capable.IModuleCapable;
import com.oryx.core.module.annotation.decl.Module;
import com.oryx.core.module.app.ApplicationModule;
import com.oryx.core.parameter.IClientParameterNames;
import com.oryx.remote.webservice.element._enum.XmlEnumUserRole;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.*;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.UUID;

@Theme("dashboard-valo-fcbk")
@Widgetset("com.oryx.core.dashboard.DashboardWidgetSet")
@Title("Oryx Dashboard")
@Module(classType = ApplicationModule.class)
@SuppressWarnings("serial")
public final class DashboardUI extends UI {
    final static Logger logger = Logger.getLogger(DashboardUI.class);
    /*
     * This field stores an access to the dummy backend layer. In real
     * applications you most likely gain access to your beans trough lookup or
     * injection; and not in the UI but somewhere closer to where they're
     * actually accessed.
     */
    private final DataProvider dataProvider = new DummyDataProvider();
    private final DashboardEventBus dashboardEventbus = new DashboardEventBus();
    private IModule module;

    /**
     * @return An instance for accessing the (dummy) services layer.
     */
    public static DataProvider getDataProvider() {
        return ((DashboardUI) getCurrent()).dataProvider;
    }

    public static DashboardEventBus getDashboardEventbus() {
        return ((DashboardUI) getCurrent()).dashboardEventbus;
    }

    @Override
    protected void init(final VaadinRequest request) {
        setLocale(Locale.US);
        DashboardEventBus.register(this);
        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);

        updateContent();

        // Some views need to be aware of browser resize events so a
        // BrowserResizeEvent gets fired to the event bus on every occasion.
        Page.getCurrent().addBrowserWindowResizeListener(
                new BrowserWindowResizeListener() {
                    @Override
                    public void browserWindowResized(
                            final BrowserWindowResizeEvent event) {
                        DashboardEventBus.post(new BrowserResizeEvent());
                    }
                });
    }

    /**
     * Updates the correct content for this UI based on the current user status.
     * If the user is logged in with appropriate privileges, main view is shown.
     * Otherwise login view is shown.
     */
    private void updateContent() {
        User user = (User) VaadinSession.getCurrent().getAttribute(
                User.class.getName());
        if (user != null && user.getRole() == XmlEnumUserRole.ROLE_ADMIN.name()) {
            // Authenticated user
            setContent(new MainView());
            removeStyleName("loginview");
            getNavigator().navigateTo(getNavigator().getState());
        } else {
            setContent(new LoginView());
            addStyleName("loginview");
        }
    }

    @Subscribe
    public void userLoginRequested(final UserLoginRequestedEvent event) {
        XmlUser xmlUser = null;
        /*
        AuthenticationServiceDelegate authenticationServiceDelegate = new AuthenticationServiceDelegate();
        XmlUser xmlUser = authenticationServiceDelegate.authenticate(event.getUserName(), event.getPassword(), VaadinSession.getCurrent().getCsrfToken());
        */

        this.module = IModuleCapable.getInstance(this);
        if (this.module != null) {
            if (!this.module.isConfigured()) {
                this.module.configure();
                this.module.initializeServices();
            }

            xmlUser = (XmlUser) this.module.AuthentificateAndLoadContext(event.getUserName(), event.getPassword(), VaadinSession.getCurrent().getCsrfToken());
        } else {
            logger.error("No module associated to Application: " + this.getClass().getSimpleName());
        }

        User user = null;
        if (xmlUser != null) {

            String applicationTheme = CommonServiceHelper.getParameterService().getValue(UUID.fromString(xmlUser.getId()), IClientParameterNames.APPLICATION_THEME);
            if (applicationTheme != null && !applicationTheme.isEmpty()) {
                setTheme(applicationTheme);
            }

            IBundleLoader.init(Page.getCurrent().getLocation().getHost(), Page.getCurrent().getLocation().getPort(), VaadinService.getCurrentRequest().getContextPath(), getTheme());


            user = new User(xmlUser);
            VaadinSession.getCurrent().setAttribute(User.class.getName(), user);
        }

        updateContent();
    }

    @Subscribe
    public void userLoggedOut(final UserLoggedOutEvent event) {
        // When the user logs out, current VaadinSession gets closed and the
        // page gets reloaded on the login screen. Do notice the this doesn't
        // invalidate the current HttpSession.
        VaadinSession.getCurrent().close();
        Page.getCurrent().reload();
    }

    @Subscribe
    public void closeOpenWindows(final CloseOpenWindowsEvent event) {
        for (Window window : getWindows()) {
            window.close();
        }
    }
}
