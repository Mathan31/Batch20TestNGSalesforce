package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	
	public static String readDataFromPropertyFile(String fileName,String propertyKey) {
		File file = new File("./data/"+fileName+".properties");
		FileInputStream fis;
		String propertyValue = "";
		try {
			fis = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fis);
			propertyValue = properties.getProperty(propertyKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyValue;
	}

}
