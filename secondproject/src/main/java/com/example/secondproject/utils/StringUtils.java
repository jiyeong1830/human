package com.example.secondproject.utils;

import org.apache.logging.log4j.util.Strings;

import java.util.regex.Pattern;

public class StringUtils {
    public static String removeTags(String str) {
        if (Strings.isEmpty(str)) {
            return str;
        }

        return Pattern.compile("<.+?>").matcher(str).replaceAll("");
    }
}
