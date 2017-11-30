package com.oryx.core.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.config.EasyFactoryConfiguration;
import org.apache.velocity.tools.generic.ResourceTool;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * Created by smbarki on 27/09/2017.
 */
public interface IVelocityLoader {
    public static final VelocityEngine velocityEngine = new VelocityEngine();
    public static final Map<Locale, Context> localizedVelocityContexts = new HashMap<>();

    public static void createVelocityEngine(String host, int port, String contextPath, String theme) {
        Properties velocityProperties = new Properties();
        velocityProperties.put("resource.loader", "url");
        velocityProperties
                .put("url.resource.loader.class",
                        "org.apache.velocity.runtime.resource.loader.URLResourceLoader");
        velocityProperties.put("url.resource.loader.root",
                "http://"
                        + host
                        + ":"
                        + port
                        //+ VaadinService.getCurrentRequest().getContextPath()
                        + contextPath
                        + "/VAADIN/themes/"
                        //+ "tests-valo-dark"
                        + theme
                        + "/layouts/");
        velocityEngine.init(velocityProperties);
    }


    public static Context createVelocityContexts(Locale locale, String bundles) {
        localizedVelocityContexts.put(locale,
                createContextForLocale(locale, bundles));

        // get the Velocity context for the current locale
        Context ctx = localizedVelocityContexts.get(locale);
        if (ctx == null) {
            // use English as the default language
            ctx = localizedVelocityContexts.get(Locale.ENGLISH);
        }

        return ctx;
    }

    public static Context createContextForLocale(Locale locale, String bundles) {
        EasyFactoryConfiguration config = new EasyFactoryConfiguration();
        config.toolbox(Scope.APPLICATION)
                .tool("msg", ResourceTool.class)
                .property("bundles", bundles)
                .property("locale", locale);

        ToolManager manager = new ToolManager(false, false);
        manager.configure(config);

        return manager.createContext();
    }

    public static InputStream getLayoutTemplate(Locale locale, String bundles, Context ctx) {
        if (locale == null) {
            locale = Locale.ENGLISH;
        }

        // let Velocity load the template through its URLResourceLoader
        Template template =
                velocityEngine.getTemplate(bundles + ".html");
        StringWriter writer = new StringWriter();

        // let Velocity do its template processing
        template.merge(ctx, writer);

        // return the result as an InputStream which can be
        // used to initialize a CustomLayout
        return new ByteArrayInputStream(
                writer.toString().getBytes(Charset.forName("UTF-8")));
    }
}
