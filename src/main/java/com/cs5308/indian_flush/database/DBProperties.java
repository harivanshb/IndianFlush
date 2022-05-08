package com.cs5308.indian_flush.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBProperties {

	Map<String, Object> properties = null;

	public Map<String, String> getProperties() throws Exception, IOException {

		Map<String, String> result = new HashMap<>();
		String appConfigPath = System.getProperty("user.dir") + "/src/main/resources/dev/service.config.properties";

		Properties appProps = new Properties();
		appProps.load(new FileInputStream(appConfigPath));
		String pass = appProps.getProperty("spring.datasource.password");
		String user = appProps.getProperty("spring.datasource.username");
		String url = appProps.getProperty("spring.datasource.url");
		result.put("pass", pass);
		result.put("user", user);
		result.put("url", url);
		return result;
	}

}
