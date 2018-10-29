package com.cy.util;


public class StringUtils {
    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static int isEmpty(String... string) {
        int result = -1;

        if (string != null)
            for (int i = 0; i < string.length; i++)
                if (string[i] == null || string[i].isEmpty())
                    result = i;

        return result;
    }
}
