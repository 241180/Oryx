package com.oryx.core.frame;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.ApplicationConstantsBundle;
import com.oryx.core.bundle.common.ErrorConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;
import com.oryx.core.bundle.loader.IBundleLoader;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.module.IModule;
import com.oryx.core.module.annotation.capable.IModuleCapable;
import com.oryx.core.module.annotation.decl.Module;
import com.oryx.core.module.app.ApplicationModule;
import com.oryx.core.parameter.IClientParameterDefault;
import com.oryx.core.parameter.IClientParameterNames;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Theme("tests-valo-facebook")//{ "valo", "reindeer", "runo", "chameleon" , "Dark"};
@Bundle(classType = ApplicationConstantsBundle.class)
@Module(classType = ApplicationModule.class)
@Widgetset("com.oryx.core.widgetset.WidgetSet")
public class ApplicationFrame extends UI {
    final static Logger logger = Logger.getLogger(ApplicationFrame.class);
    final static Map<String, ApplicationPanel> appPanelMap = new HashMap<>();
    private IModule module;

    public ApplicationFrame() {
        super();
    }

    @Override
    protected void init(VaadinRequest request) {
        try {
            //check connection
            URL url = null;
            //"http://localhost:8680/oryx-server/AdressService.wsdl"
            String host = null; //CommonServiceHelper.getParameterService().getValue(IClientParameterNames.HOST);
            if (host == null || host.isEmpty()) host = IClientParameterDefault.HOST;
            String port = null; //CommonServiceHelper.getParameterService().getValue(IClientParameterNames.PORT);
            if (port == null || port.isEmpty()) port = IClientParameterDefault.PORT;
            String path = null; //CommonServiceHelper.getParameterService().getValue(IClientParameterNames.PATH);
            if (path == null || path.isEmpty()) path = IClientParameterDefault.PATH;

            StringBuilder urlStr = new StringBuilder("http://").append(host).append(":").append(port).append("/").append(path).append("/").append("UserService.wsdl");

            url = new URL(urlStr.toString());
            URLConnection urlConnection = url.openConnection();

            if (urlConnection.getContent() != null) {
                //start connection

                IBundleLoader.init(Page.getCurrent().getLocation().getHost(), Page.getCurrent().getLocation().getPort(), VaadinService.getCurrentRequest().getContextPath(), getTheme());

                XmlUser xmlUser = null;
                this.module = IModuleCapable.getInstance(this);
                if (this.module != null) {
                    if (!this.module.isConfigured()) {
                        this.module.configure();
                        this.module.initializeServices();
                    }

                    xmlUser = (XmlUser) this.module.AuthentificateAndLoadContext("admin", "admin", VaadinSession.getCurrent().getCsrfToken());
                } else {
                    logger.error("No module associated to Application: " + this.getClass().getSimpleName());
                }

                //set application theme
                String applicationTheme = CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.APPLICATION_THEME);
                if (applicationTheme != null && !applicationTheme.isEmpty()) {
                    setTheme(applicationTheme);
                }

                ApplicationPanel panel = null;
                if (appPanelMap.containsKey(VaadinSession.getCurrent().getCsrfToken())) {
                    panel = appPanelMap.get(VaadinSession.getCurrent().getCsrfToken());
                } else {
                    panel = new ApplicationPanel();
                    appPanelMap.put(VaadinSession.getCurrent().getCsrfToken(), panel);
                }

                panel.setSizeFull();
                panel.init(request, null);
                setContent(panel);
            } else {
                Notification.show(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "404 Failed opening connection. Perhaps WS is not up?"));
                setContent(new Label("404 Failed opening connection. Perhaps WS is not up?"));
            }

        } catch (MalformedURLException ex) {
            System.out.println("bad URL");
            Notification.show(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "bad URL"));
            setContent(new Label("404 bad URL"));
        } catch (Exception ex) {
            System.out.println("Failed opening connection. Perhaps WS is not up?");
            Notification.show(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "404 Failed opening connection. Perhaps WS is not up?"));
            setContent(new Label("404 Failed opening connection. Perhaps WS is not up?"));
        }
    }
}
