package com.oryx.core.bundle.translation;

import com.oryx.core.bundle.IBundle;
import com.oryx.core.enums.EnumLanguage;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by smbarki on 05/09/2017.
 */
public interface IBundleTranslation {
    final static Logger logger = Logger.getLogger(IBundleTranslation.class);

    public static final EnumLanguage defaultLangauge = EnumLanguage.FRA;
    public static final Map<EnumLanguage, Map<String, Map<String, String>>> translationMap = new HashMap<>();

    public static boolean isLoaded() {
        return (translationMap != null && translationMap.size() > 0) ? true : false;
    }

    public static Map<String, Map<String, String>> getTansMapByLanguage(EnumLanguage lang) {
        return translationMap.get(lang != null ? lang : defaultLangauge);
    }

    public static Map<String, String> getTansMapByLangAndBundle(EnumLanguage lang, Class<? extends IBundle> bundle) {
        return translationMap.get(lang != null ? lang : defaultLangauge).get(bundle.getSimpleName());
    }

    public static String getTanslation(Class<? extends IBundle> bundle, String text) {
        if (translationMap.get(defaultLangauge) != null) {
            if (translationMap.get(defaultLangauge).get(bundle.getSimpleName()) != null) {
                return translationMap.get(defaultLangauge).get(bundle.getSimpleName()).get(text);
            }
        }

        return null;
    }

    public static void addTranslation(EnumLanguage lang, String bundleCode, String text, String translation) {
        Map<String, Map<String, String>> langMap = translationMap.get(lang);
        if (langMap == null) {
            langMap = new HashMap<>();
            translationMap.put(lang, langMap);
        }

        Map<String, String> textMap = langMap.get(bundleCode);
        if (textMap == null) {
            textMap = new HashMap<>();
            langMap.put(bundleCode, textMap);
        }

        textMap.put(text, translation);
    }
}
