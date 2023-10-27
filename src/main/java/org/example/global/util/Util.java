package org.example.global.util;

public class Util {
    public static class string {
        public static int parseInt(String paramValue, int defaultValue) {
            if (paramValue != null) {
                try {
                    return Integer.parseInt(paramValue);
                } catch (NumberFormatException e) {
                    return defaultValue;
                }
            }
            return defaultValue;
        }
    }
}
