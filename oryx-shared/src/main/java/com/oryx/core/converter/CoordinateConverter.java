package com.oryx.core.converter;

/**
 * Created by smbarki on 23/08/2017.
 */
public interface CoordinateConverter {
    // format 48°51'45.381"N => 48 + 51/60 + 45.381/3600 = 48.86261
    public static Double dmsToDecimal(String dms) {
        if (!dms.matches("(-)?[0-6][0-9]°[0-6]*[0-9]\'[0-6]*[0-9](.[0-9]{1,5})?\"(N|S|E|W)")) {
            throw new IllegalArgumentException();
        }
        String[] strArray = dms.split("[°\'\"]");

        int sign = ("S".equals(strArray[3]) || "W".equals(strArray[3])) ? -1 : 1;

        return sign * (Double.parseDouble(strArray[0]) + Double.parseDouble(strArray[1]) / 60 + Double.parseDouble(strArray[2]) / 3600);
    }

    public static String convertLatitudeToDms(Double latitude) {
        String result = "";
        if (latitude != null) {
            String direction = "N";
            if (latitude < 0) {
                direction = "S";
            }
            result = convertToDms(latitude) + direction;
        }
        return result;
    }

    public static String convertLongitudeToDms(Double longitude) {
        String result = "";
        if (longitude != null) {
            String direction = "E";
            if (longitude < 0) {
                direction = "W";
            }
            result = convertToDms(longitude) + direction;
        }
        return result;
    }

    public static String convertToDms(Double decimalDegrees) {
        decimalDegrees = Math.abs(decimalDegrees);

        // degrees
        Integer degrees = decimalDegrees.intValue();
        String dmsString = String.valueOf(degrees) + '°';

        // minutes
        decimalDegrees = (decimalDegrees - degrees) * 60;
        Integer minutes = decimalDegrees.intValue();
        dmsString = dmsString + String.valueOf(minutes) + '\'';

        // seconds
        decimalDegrees = (decimalDegrees - minutes) * 60;
        float seconds = decimalDegrees.floatValue();
        dmsString = dmsString + String.valueOf(seconds) + '"';

        return dmsString;
    }
}
