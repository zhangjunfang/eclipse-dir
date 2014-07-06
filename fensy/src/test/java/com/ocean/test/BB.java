/**
 * 
 */
package com.ocean.test;

/**
 * @author junfang
 *
 */
public class BB {
	public static String getString() {
		System.out.println("1111");
		return " dggdgdgdgdg";

	}

	public static String getString2() {
		System.out.println("222");
		return " wwwwwwwwwwwwwww";

	}
	
	public  String getString3() {
		System.out.println("3333");
		return " dggdgdgdgdg";

	}

	public  String getString4() {
		System.out.println("44444");
		return " wwwwwwwwwwwwwww";

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BB bb=new BB();
		String  temp=bb.getString4()+bb.getString3();
		System.out.println(temp);

	}

}
