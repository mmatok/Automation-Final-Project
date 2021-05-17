package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

	public static String readProperty(String key) {

		// the value that is inside the file
		String value = "";
		try (InputStream input = new FileInputStream("./src/data/configuration.properties")) {
			Properties prop = new Properties();
			// load a properties file
			prop.load(input);
			value = prop.getProperty(key);
		} catch (Exception e) {

		}
		// returns the value to read from the file
		return value;
	}
}
