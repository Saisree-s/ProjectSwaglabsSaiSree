package genericlibrary;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Properties;

	public class PropertiesLibrary implements FrameworkConstant{

		static FileInputStream fis;

		static FileOutputStream fos;

		static Properties property;

		public static String readData(String key) {

			// convert the External file into java understandable
			try {
			
				fis = new FileInputStream(propertypath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			// create an object for properties class
			property = new Properties();

			// load the properties
			try {
				property.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// read the data
			return property.getProperty(key);
		}

		public static void writeData(String newkey, String newdata, String message) {

			// 1. convert the External file into java understandable
			try {
				fis = new FileInputStream(propertypath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 2.create an object for properties class
			property = new Properties();

			// 3.load the properties
			try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 4.put all the new data in properties file
			property.put(newkey, newdata);

			// 5.convert the java understandable into external file
			try {
				fos = new FileOutputStream(propertypath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			// 6.store the new data with message
			try {
				property.store(fos, message);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

