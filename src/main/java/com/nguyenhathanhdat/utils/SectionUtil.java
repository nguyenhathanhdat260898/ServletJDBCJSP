package com.nguyenhathanhdat.utils;

import javax.servlet.http.HttpServletRequest;

public class SectionUtil {

	public static SectionUtil sectionUtil = null;

	public static SectionUtil getIntance() {
		if (sectionUtil == null) {
			sectionUtil = new SectionUtil();
		}
		return null;
	}

	public void putValue(HttpServletRequest req, String key, Object value) {
		req.getSession().setAttribute(key, value);
	}

	public Object getValue(HttpServletRequest req, String key) {
		return req.getAttribute(key); 
	}

	public void removeValue(HttpServletRequest req, String key) {
		req.getSession().removeAttribute(key);
	}
}
