package com.solitardj9.msa.utils.stringUtils;

import org.apache.commons.lang3.StringUtils;

public class RouteFilterStringUtils {

	public static Boolean isNullOrEmpty(String str) {
        return StringUtils.isEmpty(str) || StringUtils.isBlank(str);
    }
}