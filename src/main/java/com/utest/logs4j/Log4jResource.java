package com.utest.logs4j;

public class Log4jResource {

	public static String getResourcePath(String path) {

		String basePath = System.getProperty("user.dir");
		return basePath + "/" + path;

	}
}
