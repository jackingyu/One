package com.elnido.modules.masterdata.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author baogang
 */
public class ElnidoUtil {

    public static String handleJeecgFuzzySearchString(String input) {
        if ((StringUtils.indexOf(input, "*") == -1)) {
            return input;
        }

        return StringUtils.replace(input, "*", "");
    }
}
