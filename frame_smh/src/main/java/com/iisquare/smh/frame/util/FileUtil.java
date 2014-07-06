package com.iisquare.smh.frame.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件处理操作类
 */
public class FileUtil {
	
	public static boolean isExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}
	
	public static boolean delete(String filePath) {
		File file = new File(filePath);
		return file.delete();
	}
	
	public static String getContent(String fileName) {
		return getContent(fileName, false);
	}
	
	/**
	 * 获取文件内容
	 * @param fileName 文件路径
	 * @param bDislodgeLine 是否去除换行
	 * @return 文件不存在或读取异常时返回null
	 */
	public static String getContent(String fileName, boolean bDislodgeLine) {
		String output = "";
		File file = new File(fileName);
		if (!file.exists()) return null;
		if (!file.isFile()) return null;
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			StringBuffer buffer = new StringBuffer();
			String text;
			while ((text = input.readLine()) != null) {
				buffer.append(text);
				if(!bDislodgeLine) buffer.append("\n");
			}
			output = buffer.toString();
		} catch (IOException ioException) {
			return null;
		}
		return output; 
	}
}
