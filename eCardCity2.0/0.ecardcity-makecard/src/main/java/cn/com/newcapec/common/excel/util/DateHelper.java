package cn.com.newcapec.common.excel.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.time.DateUtils;

/**
 * <p>
 * 功能描述:日期常用方法
 *   
 * Author : Wangjian 
 * Date   : 2007-11-14
 * Time   : 09:28:23
 * Version: 1.2
 * </p>
 */
public class DateHelper
{
	/* 日期格式 */
	public static final String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String MIDDLE_DATE_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * <p>
	 * 功能描述：将日期转化为指定格式的字符串
	 * 
	 * @param date 日期
	 * @param format 格式字符串
	 * @return String 返回转化后的字符串,若转化出错则返回空串
	 * </p>
	 */
	public static String formatDate(Date date, String format)
	{
		try
		{
			return new SimpleDateFormat(format).format(date);
		}
		catch (Exception e)
		{
			return "";
		}
	}

	/**
	 * <p>
	 * 功能描述：将指定格式的字符串转化为日期
	 * 
	 * @param source 源字符串
	 * @param format 格式字符串
	 * @return Date 返回转化后的日期串,若转化出错则返回null
	 * </p>
	 */
	public static Date parseDate(String source, String format)
	{
		try
		{
			return new SimpleDateFormat(format).parse(source);
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	/**
	 * @param strDate
	 * @return
	 * @author Wangjian
	 * Date
	 *  转换Excel时间格式
	 */
	public static Date convertExcelDateFormat(String strDate){
		Date result = verifyExcelDateFormat(strDate);
		
		if(result == null){
			return new Date();
		}
		
		return result;
	}
	
	/**
	 * @param strDate
	 * @return
	 * @author Wangjian
	 * boolean
	 * 校验Excel时间格式 
	 */
	public static Date verifyExcelDateFormat(String strDate) {
		
		String[] parsePatterns = {"yyyy/MM/dd","yyyy-MM-dd","yyyy-MM"};
		
		//dd/MM/yyyy与yyyy/MM/dd互相冲突，所以在此要加以区别
		if(strDate.indexOf("/") == 2){
			parsePatterns[0] = "dd/MM/yyyy";
		}
	      
		try {
			return DateUtils.parseDate(strDate, parsePatterns);
		} catch (ParseException e) {

		}

		return null;
	}//end of verifyExcelDateFormat
	
	public static void main(String[] args) {
		try {
			String filePath = "c:\\test.xls";
			InputStream is = new FileInputStream(filePath);
			Workbook wb = Workbook.getWorkbook(is); //得到工作薄     
			Sheet sheet = wb.getSheet(0); //得到工作薄中的第一个工作表   
			Cell cell = sheet.getCell(0, 0);//得到工作表的第一个单元格,即A1   
			String content = cell.getContents();//getContents()将Cell中的字符转为字符串 

			System.out.println("A1内容==" + content + "  type=" + cell.getType());
			System.out.println(convertExcelDateFormat(content));

			cell = sheet.getCell(0, 1);//得到工作表的第一个单元格,即A1   
			content = cell.getContents();//getContents()将Cell中的字符转为字符串   
			System.out.println("A2内容==" + content + "  type=" + cell.getType());
			System.out.println(convertExcelDateFormat(content));

			cell = sheet.getCell(0, 2);//得到工作表的第一个单元格,即A1   
			content = cell.getContents();//getContents()将Cell中的字符转为字符串   
			System.out.println("A3内容==" + content + "  type=" + cell.getType());
			System.out.println(convertExcelDateFormat(content));

			cell = sheet.getCell(0, 3);//得到工作表的第一个单元格,即A1   
			content = cell.getContents();//getContents()将Cell中的字符转为字符串   
			System.out.println("A4内容==" + content + "  type=" + cell.getType());
			System.out.println(convertExcelDateFormat(content));

			cell = sheet.getCell(0, 4);//得到工作表的第一个单元格,即A1   
			content = cell.getContents();//getContents()将Cell中的字符转为字符串   
			System.out.println("A5内容==" + content + "  type=" + cell.getType());
			System.out.println(convertExcelDateFormat(content));

			wb.close();//关闭工作薄   
			is.close();//关闭输入流   

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
