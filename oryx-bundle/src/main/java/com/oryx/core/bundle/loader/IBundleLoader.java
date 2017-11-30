package com.oryx.core.bundle.loader;

import com.oryx.core.velocity.IVelocityLoader;
import org.apache.velocity.context.Context;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by SAMI on 24/02/2017.
 */
public interface IBundleLoader {
    public static Map<Locale, Map<String, Context>> velocitycontextMap = new HashMap<>();

    public static void init(String host, int port, String contextPath, String theme) {
        IVelocityLoader.createVelocityEngine(host, port, contextPath, theme);
    }

    public static void registerContext(Locale locale, String bundles, Context ctx) {
        Map<String, Context> contextMap = null;
        if (velocitycontextMap.containsKey(locale)) {
            contextMap = velocitycontextMap.get(locale);
        } else {
            contextMap = new HashMap<>();
            velocitycontextMap.put(locale, contextMap);
        }

        if (!contextMap.containsKey(bundles)) {
            contextMap.put(bundles, ctx);
        }
    }

    public static Context getContext(Locale locale, String bundles) {
        Context ctx = null;
        Map<String, Context> contextMap = null;
        if (velocitycontextMap.containsKey(locale) && velocitycontextMap.get(locale).containsKey(bundles)) {
            return velocitycontextMap.get(locale).get(bundles);
        } else {
            ctx = IVelocityLoader.createVelocityContexts(locale, bundles);
            registerContext(locale, bundles, ctx);
            return ctx;
        }
    }

    public static InputStream getLayoutTemplate(Locale locale, String bundles) {
        Context ctx = null;
        Map<String, Context> contextMap = null;
        if (velocitycontextMap.containsKey(locale) && velocitycontextMap.get(locale).containsKey(bundles)) {
            ctx = velocitycontextMap.get(locale).get(bundles);
        } else {
            ctx = IVelocityLoader.createVelocityContexts(locale, bundles);
            registerContext(locale, bundles, ctx);
        }

        return IVelocityLoader.getLayoutTemplate(locale, bundles, ctx);
    }
}
