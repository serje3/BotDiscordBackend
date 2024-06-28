package org.serje3.BotBackend.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookieFormatter {

    public static String formatCookies(List<String> cookies) {
        // Строим результирующую строку
        StringBuilder formattedCookies = new StringBuilder();
        for (String cookie : cookies) {
            // Удаляем параметры, оставляя только ключ=значение
            String cookieKeyValue = cookie.split(";")[0];
            formattedCookies.append(cookieKeyValue).append("; ");
        }

        // Удаляем последний лишний пробел и точку с запятой
        if (!formattedCookies.isEmpty()) {
            formattedCookies.setLength(formattedCookies.length() - 2);
        }

        return formattedCookies.toString();
    }

    public static Map<String, String> clearParseCookies(String cookieHeader) {
        Map<String, String> cookieMap = new HashMap<>();
        String[] cookies = cookieHeader.split(", ");

        for (String cookie : cookies) {
            String cookieKeyValue = cookie.split(";")[0];
            String[] parts = cookieKeyValue.split("=", 2);
            if (parts.length == 2) {
                cookieMap.put(parts[0], parts[1]);
            }
        }

        return cookieMap;
    }

    public static Map<String, String> parseCookies(String cookieHeader) {
        Map<String, String> cookieMap = new HashMap<>();
        String[] cookies = cookieHeader.split(";");
        for (String cookie : cookies) {
            String[] parts = cookie.split("=", 2);
            if (parts.length == 2) {
                cookieMap.put(parts[0].trim(), parts[1].trim());
            }
        }
        return cookieMap;
    }

    public static String formatCookies(Map<String, String> cookieMap) {
        StringBuilder formattedCookies = new StringBuilder();

        for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
            formattedCookies.append(entry.getKey()).append("=").append(entry.getValue()).append("; ");
        }

        // Удаляем последний лишний пробел и точку с запятой
        if (!formattedCookies.isEmpty()) {
            formattedCookies.setLength(formattedCookies.length() - 2);
        }

        return formattedCookies.toString();
    }

    public static String mergeCookies(String oldCookies, String newCookies) {
        Map<String, String> oldCookieMap = parseCookies(oldCookies);
        Map<String, String> newCookieMap = parseCookies(newCookies);
        // Обновляем старые куки и добавляем новые
        oldCookieMap.putAll(newCookieMap);
        return formatCookies(oldCookieMap);
    }
}
