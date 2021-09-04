package org.namph.blog.util;

public class CommonUtil {
    
    /**
     * check null or empty object and string
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return null == obj || obj.equals("");
    }
}
