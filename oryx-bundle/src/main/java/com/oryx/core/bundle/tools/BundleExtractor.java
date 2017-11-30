package com.oryx.core.bundle.tools;

import com.oryx.core.bundle.IBundle;
import com.oryx.core.bundle.translation.IBundleTranslation;
import org.apache.log4j.Logger;

/**
 * Created by SAMI on 24/02/2017.
 */
public interface BundleExtractor {
    final static Logger logger = Logger.getLogger(BundleExtractor.class);

    public static String getStringValue(Class<? extends IBundle> bundleClass, String caption) {
        if (bundleClass != null) {
            String text = IBundleTranslation.getTanslation(bundleClass, caption);
            if (text == null) {
                //ResourceBundle labels = ResourceBundle.getBundle(bundleClass.getSimpleName(), Locale.ENGLISH);
                //text = labels.getString(caption);
                if (text == null) {
                    text = IBundle.getDefaultStringValue(bundleClass, caption);
                }
            }

            return text;
        } else {
            logger.error("No bundle interface provided.");
            return caption;
        }
    }

    public static Boolean isReadOnly(Class<? extends IBundle> bundleClass, String caption) {
        if (bundleClass != null) {
            return IBundle.isReadOnly(bundleClass, caption);
        } else {
            logger.error("No bundle interface provided.");
            return false;
        }
    }

    public static Boolean isMandatory(Class<? extends IBundle> bundleClass, String caption) {
        if (bundleClass != null) {
            return IBundle.isMandatory(bundleClass, caption);
        } else {
            logger.error("No bundle interface provided.");
            return false;
        }
    }

    public static int getLength(Class<? extends IBundle> bundleClass, String caption) {
        if (bundleClass != null) {
            return IBundle.getLength(bundleClass, caption);
        } else {
            logger.error("No bundle interface provided.");
            return 128;
        }
    }
}
