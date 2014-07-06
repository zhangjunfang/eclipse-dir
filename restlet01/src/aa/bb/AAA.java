package aa.bb;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.servlet.DispatcherServlet;

public class AAA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// properties=new Properties();
		try {

			// properties.load(AAA.class.getClassLoader().getResourceAsStream("restletUrlMapping.properties"));
			//
			// System.out.println(properties.get("students.stuListUI"));
			// ===============================================================================================
			// properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("restletUrlMapping.properties"));
			//
			// System.out.println(properties.get("students.stuListUI"));
			// ==========================================================================================================================
			// UrlResource resource = new
			// UrlResource(DispatcherServlet.class.getPackage().getName().replaceAll("\\.",
			// "/")+"/"+"DispatcherServlet.properties");
			// System.out.println("====="+DispatcherServlet.class.getPackage().getName().replaceAll("\\.",
			// "/"));
			// Properties
			// properties=PropertiesLoaderUtils.loadProperties(resource);
			//
			// System.out.println(properties.get("org.springframework.web.servlet.LocaleResolver"));
			// ================================================================================================================
			// String
			// classPathString=DispatcherServlet.class.getPackage().getName().replaceAll("\\.",
			// "/")+"/"+"DispatcherServlet.properties";
			// InputStream resource=
			// ClassLoader.getSystemResourceAsStream(classPathString);
			// Properties properties=new Properties();
			// properties.load(resource);
			// System.out.println(properties.get("org.springframework.web.servlet.LocaleResolver"));
			// =========================================================================================================================
			String jarPathString = DispatcherServlet.class.getPackage()
					.getName().replaceAll("\\.", "/")
					+ "/" + "DispatcherServlet.properties";
			InputStream resource = ClassLoader
					.getSystemResourceAsStream(jarPathString);
			Properties properties = new Properties();
			properties.load(resource);
			System.out.println(properties
					.get("org.springframework.web.servlet.LocaleResolver"));
			// ===========================================================================

			ClassPathResource resource2 = new ClassPathResource(
					"org/springframework/web/servlet/DispatcherServlet.properties");
			System.out.println(resource2.getURL());
			Properties properties2 = PropertiesLoaderUtils
					.loadProperties(resource2);
			System.out
					.println("value:==="
							+ properties2
									.get("org.springframework.web.servlet.LocaleResolver"));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
