package cn.com.newcapec.common.excel.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.newcapec.common.excel.exception.ExcelCreateException;
import cn.com.newcapec.common.excel.util.ExcelHelper;

/**
 * <pre>
 * 功能描述:生成EXCEL文件
 *
 * Author : Wangjian
 * Date   : 2007-11-15
 * Time   : 17:02:34
 * Version:1.0
 * </pre>
 */
public class ExcelCreate
{
	private final Log log = LogFactory.getLog(this.getClass());

	private final ExcelMappingConfig excelMappingConfig; //EXCEL配置信息存储类

	public ExcelCreate(ExcelMappingConfig excelMappingConfig)
	{
		this.excelMappingConfig = excelMappingConfig;
	}

	/**
	 * <pre>
	 * 生成EXCEL工作薄,输出到文件
	 *
	 * @param excelEntityList EXCEL文件内容列表
	 * @param file 生成后的EXCEL文件
	 *
	 * @throws ExcelCreateException  生成Excel运行时异常
	 * </pre>
	 */
	public void createExcel(final List excelEntityList,File file) throws ExcelCreateException
	{
		createExcel(excelEntityList, null, file);
	}

	/**
	 * <pre>
	 * 生成EXCEL工作薄,输出到文件
	 *
	 * @param excelEntityList EXCEL文件内容列表
	 * @param headName EXCEL表头名称
	 * @param file 生成后的EXCEL文件
	 *
	 * @throws ExcelCreateException  生成Excel运行时异常
	 * </pre>
	 */
	public void createExcel(final List excelEntityList,final String headName,File file) throws ExcelCreateException
	{
		try
		{
			createExcel(excelEntityList,headName,new FileOutputStream(file));
		}
		catch (Exception e)
		{
			if (log.isErrorEnabled())
			{
				log.error("生成EXCEL文件时出错:" + e.getMessage());
			}
			throw new ExcelCreateException(e.getMessage());
		}
	}

	/**
	 * <pre>
	 * 生成EXCEL工作薄,输出到输出流中
	 *
	 * @param excelEntityList EXCEL文件内容列表
	 * @param os 输出流
	 *
	 * @throws ExcelCreateException  生成Excel运行时异常
	 * </pre>
	 */
	public void createExcel(final List excelEntityList,OutputStream os) throws ExcelCreateException
	{
		createExcel(excelEntityList, null, os);
	}

	/**
	 * <pre>
	 * 生成EXCEL工作薄,输出到输出流中
	 *
	 * @param excelEntityList EXCEL文件内容列表
	 * @param headName EXCEL表头名称
	 * @param os 输出流
	 *
	 * @throws ExcelCreateException  生成Excel运行时异常
	 * </pre>
	 */
	public void createExcel(final List excelEntityList,final String headName,OutputStream os) throws ExcelCreateException
	{
		if(excelMappingConfig==null)
		{
			throw new ExcelCreateException("没有初始化EXCEL文件配置信息");
		}
		if(excelEntityList==null||excelEntityList.size()==0)
		{
			throw new ExcelCreateException("EXCEL内容数据列表为空!");
		}
		List<String> sheetNameList = new ArrayList<String>();
		Map<String,List<Object>> entitySortedList=new HashMap<String,List<Object>>();
		String sheetNameField = excelMappingConfig.getSheetNameField();
		int entityLen=excelEntityList.size();
		for (int i=0;i<entityLen;i++)
		{
			Object obj =excelEntityList.get(i);
			String sheetName;
			try
			{
				sheetName = (String) ExcelHelper.invokeGetMethod(obj, sheetNameField);
			}
			catch (Exception e)
			{
				sheetName = null;
			}
			if(sheetName==null||sheetName.length()==0)
			{
				sheetName="Sheet1";
			}
			if(!sheetNameList.contains(sheetName))
			{
				sheetNameList.add(sheetName);
			}
			List<Object> entityList=entitySortedList.get(sheetName);
			if(entityList==null)
			{
				entityList=new ArrayList<Object>(entityLen-i);
			}
			entityList.add(obj);
			entitySortedList.put(sheetName, entityList);
		}
		WritableWorkbook writableWorkbook=null;
		try
		{
			writableWorkbook = Workbook.createWorkbook(os); // 创建EXCEL工作薄
			int sheetNameLen=sheetNameList.size();
			for (int i = 0; i < sheetNameLen ; i++)
			{
				String sheetName=sheetNameList.get(i);
				WritableSheet writableSheet = writableWorkbook.createSheet(sheetName, i);
				writeSheet(writableSheet, headName, entitySortedList.get(sheetName));
			}
            writableWorkbook.write();
        }
		catch (Exception e)
		{
			if (log.isErrorEnabled())
			{
				log.error("创建EXCEL文件时出错:" + e.getMessage());
			}
			throw new ExcelCreateException(e.getMessage());
		}
		finally
		{
			if(writableWorkbook!=null)
			{
				try
				{
					writableWorkbook.close();
				}
				catch (Exception e)
				{
                    log.error("关闭EXCEL文件时出错:" + e.getMessage());
                }
			}
		}
	}

	/**
	 * <pre>
	 * 生成EXCEL文件中的一张工作表
	 *
	 * @param writableSheet 工作表对象
	 * @param headName EXCEL表头名称
	 * @param entityList 工作表数据列表
	 *
	 * @throws ExcelCreateException  生成Excel运行时异常
	 * </pre>
	 */
	private void writeSheet(WritableSheet writableSheet,final String headName, List<Object> entityList)
			throws ExcelCreateException
	{
		if (entityList == null || entityList.size()==0)
		{
			return;
		}
		Map<String,Object> head= excelMappingConfig.getHead();
		if(head.size()>0)
		{
			try
			{
				WritableFont headWritableFont = new WritableFont(WritableFont.ARIAL, 20, WritableFont.BOLD);
				WritableCellFormat headWritableCellFormat = new WritableCellFormat(headWritableFont);
				headWritableCellFormat.setAlignment(Alignment.CENTRE);
				headWritableCellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
				headWritableCellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

				Integer beginColumn=(Integer)head.get("beginColumn");
				Integer beginRow=(Integer)head.get("beginRow");
				Integer endColumn=(Integer)head.get("endColumn");
				Integer endRow=(Integer)head.get("endRow");
				writableSheet.mergeCells(beginColumn,beginRow,endColumn,endRow);

				Label label = new Label(beginColumn,
						beginRow,
						headName,
						headWritableCellFormat);
				writableSheet.addCell(label);

				Integer height=(Integer)head.get("height");
				if(height!=null)
				{
					writableSheet.setRowView(beginRow, height);
				}
			}
			catch(Exception e)
			{
				if (log.isErrorEnabled())
				{
					log.error("创建EXCEL表头时出错:" + e.getMessage());
				}
			}
		}

		Map<String, WritableCellFormat> cellFormat = new HashMap<String, WritableCellFormat>();
		Map<String, Object> title=excelMappingConfig.getTitle();
		Integer titleRow=(Integer)title.get("row");
		List<Map<String, Object>> cells = excelMappingConfig.getCells();
		for (Map<String, Object> cell : cells)
		{
			try
			{
				WritableFont titleWritableFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
				WritableCellFormat titleWritableCellFormat = new WritableCellFormat(titleWritableFont);
				titleWritableCellFormat.setAlignment(Alignment.CENTRE);
				titleWritableCellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
				titleWritableCellFormat.setBackground(jxl.format.Colour.GREY_50_PERCENT);
				titleWritableCellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

				Integer column=(Integer)cell.get("column");
				Label label = new Label(column,
						                titleRow,
										(String)cell.get("titleName"),
										titleWritableCellFormat);
				writableSheet.addCell(label);

				WritableFont writableFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD);
				String type = (String)cell.get("type");
				String format = (String)cell.get("format");
				if ("Double".equalsIgnoreCase(type))
				{
					WritableCellFormat writableCellFormat = new WritableCellFormat();
					if (format != null && format.length() > 0)
					{
						NumberFormat numberFormat = new NumberFormat(format);
						writableCellFormat = new WritableCellFormat(numberFormat);
					}
					writableCellFormat.setFont(writableFont);
					cellFormat.put((String)cell.get("field"), writableCellFormat);
				}
				else if ("Date".equalsIgnoreCase(type))
				{
					WritableCellFormat writableCellFormat = new WritableCellFormat();
					if (format != null && format.length() > 0)
					{
						DateFormat dateFormat = new DateFormat(format);
						writableCellFormat = new WritableCellFormat(dateFormat);
					}
					writableCellFormat.setFont(writableFont);
					cellFormat.put((String)cell.get("field"), writableCellFormat);
				}
				else
				{
					WritableCellFormat writableCellFormat = new WritableCellFormat(writableFont);
					cellFormat.put((String)cell.get("field"), writableCellFormat);
				}
				Integer width=(Integer)cell.get("width");
				if(width!=null)
				{
					try
					{
						writableSheet.setColumnView(column, width);
					}
					catch(Exception e)
					{
						if (log.isErrorEnabled())
						{
							log.error("设置行视图时出错:" + e.getMessage());
						}
					}
				}
			}
			catch (Exception e)
			{
				if (log.isErrorEnabled())
				{
					log.error("创建Cell时出错:" + e.getMessage());
				}
			}
		}
		Integer titleHeight=(Integer)title.get("height");
		if(titleHeight!=null)
		{
			try
			{
				writableSheet.setRowView(titleRow, titleHeight);
			}
			catch(Exception e)
			{
				if (log.isErrorEnabled())
				{
					log.error("设置行视图时出错:" + e.getMessage());
				}
			}
		}
		Boolean titleFreeze=(Boolean)title.get("freeze");
		if(titleFreeze!=null&&titleFreeze)
		{
			try
			{
				writableSheet.getSettings().setVerticalFreeze(titleRow+1);
			}
			catch(Exception e)
			{
				if (log.isErrorEnabled())
				{
					log.error("设置行视图时出错:" + e.getMessage());
				}
			}
		}

		Map<String,Object> data=excelMappingConfig.getData();
		int row = (Integer)data.get("begin");
		Integer height=(Integer)data.get("height");
		for (Object obj : entityList)
		{
			for (Map<String, Object> cell : cells)
			{
				try
				{
					String field = (String)cell.get("field");
					Object fieldValue = ExcelHelper.invokeGetMethod(obj, field);
					if (fieldValue != null)
					{
						String type = (String)cell.get("type");

						if ("Double".equalsIgnoreCase(type))
						{
							Number number = new Number((Integer)cell.get("column"),
													   row,
									                   (Double) fieldValue,
									                   cellFormat.get(field));
							writableSheet.addCell(number);
						}
						else if ("Date".equalsIgnoreCase(type))
						{
							DateTime dateTime = new DateTime((Integer)cell.get("column"),
															 row,
									                         (Date) fieldValue,
									                         cellFormat.get(field));
							writableSheet.addCell(dateTime);
						}
						else
						{
							Label label = new Label((Integer)cell.get("column"),
													row,
													(String) fieldValue,
													cellFormat.get(field));
							writableSheet.addCell(label);
						}
					}
				}
				catch (Exception e)
				{
					if (log.isErrorEnabled())
					{
						log.error("创建Cell时出错:" + e.getMessage());
					}
				}
			}
			if(height!=null)
			{
				try
				{
					writableSheet.setRowView(row, height);
				}
				catch(Exception e)
				{
					if (log.isErrorEnabled())
					{
						log.error("设置行视图时出错:" + e.getMessage());
					}
				}
			}
			row++;
		}
	}
}
