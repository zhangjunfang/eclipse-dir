package cn.newcapec.function.citycard.platform.ocean;

import java.io.IOException;

import org.springframework.core.io.UrlResource;



public class Spring {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String  httpString="http://192.168.101.152:8082/olxjs/examples/overall/index.html";
		UrlResource  resource=new UrlResource(httpString);
		System.out.println(resource.lastModified());
		System.out.println(resource.contentLength());
	
			
			
			
			

	}

}
