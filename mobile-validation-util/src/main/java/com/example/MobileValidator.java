package com.example;

import java.util.regex.Pattern;

public class MobileValidator {
    private static final String MOBILE_NUMBER_REGEX = "^[0-9]{10}$";
    private static final Pattern pattern = Pattern.compile(MOBILE_NUMBER_REGEX);

    public static boolean isValidMobileNumber(String mobileNumber) {
        return pattern.matcher(mobileNumber).matches();
    }
    
    public static String normalizeMobileNumber(String mobileNumber) {
        return mobileNumber.replaceAll("[^0-9]", "");
    }

    public static String formatMobileNumber(String mobileNumber) {
        String normalizedNumber = normalizeMobileNumber(mobileNumber);
        return normalizedNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
    }

    public static boolean startsWithPrefix(String mobileNumber, String prefix) {
        String normalizedNumber = normalizeMobileNumber(mobileNumber);
        return normalizedNumber.startsWith(prefix);
    }

}
