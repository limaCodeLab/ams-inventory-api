package com.skald.ats.inventory.api.utils;

public class StringUtils {

    private static String TEXT_RESULT;

    public static String normalizeString(String text) {
        if(text == null || text.trim().isEmpty()){
            return text;
        }

        TEXT_RESULT = text.substring(0,1).toUpperCase() +
                text.substring(1).trim().replaceAll("\\s+", " ");
        return TEXT_RESULT;
    }

}
