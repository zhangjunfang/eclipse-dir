package cn.com.newcapec.common.excel.service;

import cn.com.newcapec.common.excel.exception.ExcelParseException;
import cn.com.newcapec.common.excel.util.ExcelHelper;

import jxl.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.util.*;

/**
 * <pre>
 * 功能描述:解析Excel文件
 *   
 * Author : Wangjian 
 * Date   : 2007-11-15
 * Time   : 09:29:08
 * Version: 1.2
 * </pre>
 */
public class ExcelParse
{
	private final Log log = LogFactory.getLog(this.getClass());
	
	public static final String HEAD="head";//表头
	public static final String CONTENT="content";//内容
	
	private final ExcelMappingConfig excelMappingConfig; //EXCEL配置信息存储类

	public ExcelParse(ExcelMappingConfig excelMappingConfig)
	{
		this.excelMappingConfig = excelMappingConfig;
	}

	/**
	 * <pre>
	 * 解析EXCEL文件,并将EXCEL内容存入List中
	 * 
	 * @param excelFile EXCEL文件
	 * 
	 * @return List<Object> EXCEL内容
	 * 
	 * @throws ExcelParseException EXCEL文件解析异常
	 * </pre>
	 */
	public List parse(final File excelFile) throws ExcelParseException
	{
		if(excelMappingConfig==null)
		{
			throw new ExcelParseException("没有初始化EXCEL文件配置信息");
		}
		Workbook workbook;
		try
		{
			workbook = Workbook.getWorkbook(excelFile); // 打开EXCEL文件
		}
		catch (Exception e)
		{
			throw new ExcelParseException(excelFile.getName() + "不是正确的EXCEL文件，无法解析!");
		}
		List<Object> excelEntityList = new ArrayList<Object>(100);
		for (Sheet sheet:workbook.getSheets())
		{
			List<Object> list = getExcelContentList(sheet);
			if (list != null && list.size() > 0)
			{
				excelEntityList.addAll(list);
			}
		}
		return excelEntityList;
	}
	
	/**
	 * <pre>
	 * 解析EXCEL文件,并将EXCEL内容存入List中
	 * 
	 * @param excelFile EXCEL文件
	 * 
	 * @return List<Map<String,Object>> EXCEL带表头内容列表
	 * 
	 * @throws ExcelParseException EXCEL文件解析异常
	 * </pre>
	 */
	public List<Map<String,Object>> parseExcelAndHead(final File excelFile) throws ExcelParseException
	{
		if(excelMappingConfig==null)
		{
			throw new ExcelParseException("没有初始化EXCEL文件配置信息");
		}
		Workbook workbook;
		try
		{
			workbook = Workbook.getWorkbook(excelFile); // 打开EXCEL文件
		}
		catch (Exception e)
		{
			throw new ExcelParseException(excelFile.getName() + "不是正确的EXCEL文件，无法解析!");
		}
		
		List<Map<String,Object>> excelEntityList=new ArrayList<Map<String,Object>>(workbook.getNumberOfSheets());
		for (Sheet sheet:workbook.getSheets())
		{
			excelEntityList.add(getExcelContentListAndHead(sheet));
		}
		return excelEntityList;
	}
	
	/**
	 * <pre>
	 * 解析EXCEL文件,并将EXCEL内容存入List中
	 * 
	 * @param sheet EXCEL工作表
	 * 
	 * @return List<Object> EXCEL内容
	 * 
	 * @throws ExcelParseException EXCEL文件解析异常
	 * </pre>
	 */
	private Map<String,Object> getExcelContentListAndHead(Sheet sheet)
			throws ExcelParseException
	{
		Map<String,Object> excelEntity=new HashMap<String,Object>();
		Map<String,Object> head= excelMappingConfig.getHead();
		String headName=null;
		if(head.size()>0)
		{
			Integer beginColumn=(Integer)head.get("beginColumn");
			Integer beginRow=(Integer)head.get("beginRow");
			headName=sheet.getCell(beginColumn, beginRow).getContents().trim();
		}
		excelEntity.put(HEAD, headName);
		excelEntity.put(CONTENT, getExcelContentList(sheet));
		return excelEntity;
	}

	/**
	 * <pre>
	 * 解析EXCEL文件,并将EXCEL内容存入List中
	 * 
	 * @param sheet EXCEL工作表
	 * 
	 * @return List<Object> EXCEL内容
	 * 
	 * @throws ExcelParseException EXCEL文件解析异常
	 * </pre>
	 */
	private List<Object> getExcelContentList(Sheet sheet)
			throws ExcelParseException
	{
		int rowNum = sheet.getRows(); // 得到EXCEL文件的行数
		Map<String, Object> data = excelMappingConfig.getData();
		int begin = (Integer)data.get("begin");
		int end = rowNum;
		if (data.get("end") != null)
		{
			end = (Integer)data.get("end") + 1;
		}
		end = end > rowNum ? rowNum : end;
		if (begin >= end)
		{
			return null;
		}
		String sheetName=sheet.getName();
		List<Map<String, Object>> cells = excelMappingConfig.getCells();
		Map<String, Object> title=excelMappingConfig.getTitle();
		Integer titleRow= (Integer)title.get("row");
		Boolean checkTitleName=(Boolean)title.get("checkTitleName");
		if(checkTitleName!=null&&checkTitleName)
		{
			for (Map<String, Object> cell : cells)
			{
				String titleNameNew = sheet.getCell((Integer)cell.get("column"), titleRow).getContents().trim();
				String titleName=(String)cell.get("titleName");
				if(!titleName.equalsIgnoreCase(titleNameNew))
				{
					throw new ExcelParseException("工作表\""+sheetName+"\"中的列标题\""+titleName+"\"不正确!");
				}
			}
		}
		String className = excelMappingConfig.getClassName();
		Class classType;
		try
		{
			classType = Class.forName(className);
		}
		catch (Exception e)
		{
			throw new ExcelParseException(e.getMessage());
		}
		List<Object> excelEntityList = new ArrayList<Object>(end-begin);
		String sheetNameField = excelMappingConfig.getSheetNameField();
		for (int row = begin; row < end; row++)
		{
			Object excelEntity;
			try
			{
				excelEntity = ExcelHelper.getObjectByDefaultConstructor(classType);
			}
			catch (Exception e)
			{
				throw new ExcelParseException(e.getMessage());
			}
			try
			{
				ExcelHelper.invokeSetMethod(excelEntity, sheetNameField, sheetName);
			}
			catch (Exception e)
			{
				if (log.isErrorEnabled())
				{
					log.error("调用方法出错了:" + e.getMessage());
				}
			}
			for (Map<String, Object> cell : cells)
			{
				Object content;
				Cell c = sheet.getCell((Integer)cell.get("column"), row);
				if (c.getContents().trim().length() == 0)
				{
					continue;
				}
				String type = (String)cell.get("type");
				if ("Double".equalsIgnoreCase(type))
				{
					content = ((NumberCell) c).getValue();
				}
				else if ("Date".equalsIgnoreCase(type))
				{
					content = getEast8Date(((DateCell) c).getDate());
				}
				else
				{
					content = c.getContents().trim();
					Integer maxLength = (Integer)cell.get("maxLength");
					if (maxLength != null)
					{
						content = ExcelHelper.getMaxLengthString((String) content, maxLength);
					}
				}
				try
				{
					ExcelHelper.invokeSetMethod(excelEntity, (String)cell.get("field"), content);
				}
				catch (Exception e)
				{
					if (log.isErrorEnabled())
					{
						log.error("调用方法出错了:" + e.getMessage());
					}
				}
			}
			excelEntityList.add(excelEntity);
		}
		return excelEntityList;
	}

	/**
	 * <pre>
	 * 将时间转换为东八区的时间
	 * 
	 * @param date 格林威治时间(零时区时间)
	 * 
	 * @return Date 转换后的东八区时间
	 * </pre>
	 * */
	private static Date getEast8Date(Date date)
	{
		if (date == null)
		{
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, -8);
		return cal.getTime();
	}
}
