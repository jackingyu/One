package com.elnido.modules.masterdata.service;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;

/**
 * Services Utils
 * @author Bao Gang
 */
public class ServicesUtil {

    public static void validateParameterNotNull(Object parameter, String nullMessage) {
        Preconditions.checkArgument(parameter != null, nullMessage);
    }

    public static void validateParameterNotNullStandardMessage(String parameter, Object parameterValue) {
        validateParameterNotNull(parameterValue, "Parameter " + parameter + " can not be null");
    }

    public static void validateStringParameterNotBlack(String parameter, String nullMessage) {
        Preconditions.checkArgument(StringUtils.isNotBlank(parameter), nullMessage);
    }
}
