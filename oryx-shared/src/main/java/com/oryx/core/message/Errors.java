package com.oryx.core.message;

/**
 * Created by smbarki on 10/08/2017.
 */
public interface Errors {
    //SQL Errors
    public static int UNKNOWN_ERROR = 9999;
    public static int CONSTRAINT_VIOLATION = 1000;
    public static int INVALID_USER_SESSION = 2000;
    public static int INVALID_ENUM_VALUE = 3000;
    public static int INVALID_OPERATION = 4000;
}
