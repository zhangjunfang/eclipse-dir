package com.ocean.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class AA {

	/**
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {
		Map<String, String> map=new HashMap<String, String>();
		TreeMap<String, String> treeMap=new TreeMap<String, String>();
		TreeSet<String> treeset=new TreeSet<String>();
		Runtime.getRuntime().availableProcessors();
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(System.identityHashCode(treeset));
		System.out.println(System.identityHashCode(treeMap));
		System.out.println(System.identityHashCode(map));
	
	}

}
