package com.oryx.core.message;

import com.oryx.core.bundle.common.SqlConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;

/**
 * Created by smbarki on 10/08/2017.
 */
public interface ErrorMessageProvider {
    public static String getMessage(Integer errCode) {
        if (errCode == null) {
            return IMessageHelper.getDefaultString(SqlConstantBundle.class, "NULL_ERROR_CODE");
        }

        switch (errCode) {
            case Errors.CONSTRAINT_VIOLATION:
                return IMessageHelper.getDefaultString(SqlConstantBundle.class, "CONSTRAINT_VIOLATION");
            case Errors.INVALID_USER_SESSION:
                return IMessageHelper.getDefaultString(SqlConstantBundle.class, "INVALID_USER_SESSION");
            default:
                return errCode.toString();
        }
    }
}
