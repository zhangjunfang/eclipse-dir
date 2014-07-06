package cn.newcapec.function.citycard.platform.ocean;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.servlet.DispatcherServlet;

public class JARPathUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * jarPathString  jar文件中的属性文件的路径
		 * */
		String jarPathString = DispatcherServlet.class.getPackage().getName()
				.replaceAll("\\.", "/")
				+ "/" + "DispatcherServlet.properties";
		System.out.println(jarPathString);
		InputStream resource = ClassLoader
				.getSystemResourceAsStream(jarPathString);
		Properties properties = new Properties();
		properties.load(resource);
		// System.out.println("org.springframework.web.servlet.LocaleResolver = "+properties.get("org.springframework.web.servlet.LocaleResolver"));
		for (Object key : properties.keySet()) {
            
			System.out.println(key.toString()+" = "+properties.getProperty(key.toString()));
		}
		//===========================================================================
		
		ClassPathResource  resource2=new ClassPathResource("org/springframework/web/servlet/DispatcherServlet.properties");
		System.out.println(resource2.getURL());
		Properties	properties2=PropertiesLoaderUtils.loadProperties(resource2);
		System.out.println("value:==="+properties2.get("org.springframework.web.servlet.LocaleResolver"));
	}

}
