package com.oryx.core.bundle.helper;

import com.oryx.core.bundle.IBundle;
import com.oryx.core.bundle.tools.BundleExtractor;

/**
 * Created by SAMI on 25/02/2017.
 */
public interface IMessageHelper {
    public static String composeMsg(String baseStr, String... args) {
        if (baseStr == null)
            return null;
        String result = new String(baseStr);
        int counter = 1;
        for (String arg : args) {
            String target = "%" + String.valueOf(counter);
            if (arg != null) {
                result = result.replace(target, arg);
            }
            counter++;
        }
        return result;
    }

    public static String getDefaultString(Class<? extends IBundle> bundleClass, String key) {
        return BundleExtractor.getStringValue(bundleClass, key);
    }
}
