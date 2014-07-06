package cn.com.newcapec.common.excel.service;

import cn.com.newcapec.common.excel.exception.ExcelConfigException;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 功能描述:EXCEL配置信息存储类
 *   
 * Author : Wangjian 
 * Date   : 2007-11-14
 * Time   : 09:22:19
 * Version: 1.2
 * </p>
 */
public class ExcelMappingConfig
{
	private final InputStream is; //输入流
    private final String configFileName;//配置文件名称
    
    private Map<String,Object> head=new HashMap<String,Object>();//EXCEL表头
    private String className; //EXCEL文件对应类的配置信息
    private String sheetNameField; //EXCEL文件工作表名称对应JAVA字段的配置信息
    private Map<String,Object> title=new HashMap<String,Object>(); //EXCEL文件标题的配置信息
    private List<Map<String,Object>> cells = new ArrayList<Map<String,Object>>(); //EXCEL文件数据项对应JAVA字段的配置信息
    private Map<String,Object> data = new HashMap<String,Object>(); //EXCEL文件数据的配置信息

    /**
     * <p>
     * 设置EXCEL配置文件
     *
     * @param configFilePath  EXCEL配置文件路径
     *                        以"/"开始的,是相对于classpath根目录的路径;
     *                        否则相对于本文件所在目录的路径
     *
     * @throws ExcelConfigException 配置文件异常
     * </p>
     */
    public ExcelMappingConfig(String configFilePath) throws ExcelConfigException
    {
        if(configFilePath==null)
        {
            throw new ExcelConfigException("没有初始化EXCEL配置文件!");
        }
        try
		{
        	is=getClass().getResourceAsStream(configFilePath);
		}
		catch (Exception e)
		{
			throw new ExcelConfigException("没有找到EXCEL配置文件!");
		}
		configFileName=configFilePath;
        init();
    }
    
    /**
     * <p>
     * 设置EXCEL配置文件
     *
     * @param configFile  EXCEL配置文件
     *
     * @throws ExcelConfigException 配置文件异常
     * </p>
     */
    public ExcelMappingConfig(File configFile) throws ExcelConfigException
    {
        if(configFile==null)
        {
            throw new ExcelConfigException("没有初始化EXCEL配置文件!");
        }
        try
		{
			is=new FileInputStream(configFile);
		}
		catch (Exception e)
		{
			throw new ExcelConfigException("没有找到EXCEL配置文件!");
		}
		configFileName=configFile.getName();
        init();
    }
    
    public Map<String, Object> getHead()
	{
		return head;
	}

    public String getClassName()
    {
        return className;
    }

    public String getSheetNameField()
    {
        return sheetNameField;
    }
    
    public Map<String, Object> getTitle()
	{
		return title;
	}

	public List<Map<String,Object>> getCells()
    {
        return cells;
    }

    public Map<String,Object> getData()
    {
        return data;
    }

    /**
     * <p>
     * 解析EXCEL配置文件
     *
     * @throws ExcelConfigException  配置文件异常
     * </p>
     */
    private void init() throws ExcelConfigException
    {
        SAXReader saxReader = new SAXReader();
        Document doc;
        try
        {
            doc = saxReader.read(is);
        }
        catch (Exception e)
        {
            throw new ExcelConfigException("无法解析配置文件"+configFileName+"!");
        }
        
        /*读取head*/
        Element headElement = (Element)doc.selectSingleNode("excel-mapping-config/head");
        if (headElement != null)
        {
        	setMapIntegerByElementAttribute(head, headElement, "height",true);
        	
        	headElement = (Element)doc.selectSingleNode("excel-mapping-config/head/merge");
        	if(headElement ==null)
        	{
        		throw new ExcelConfigException("在配置文件" + configFileName + "中没有找到excel-mapping-config/head/merge结点!");
        	}
        	setMapIntegerByElementAttribute(head, headElement, "beginColumn",false);
        	setMapIntegerByElementAttribute(head, headElement, "beginRow",false);
        	setMapIntegerByElementAttribute(head, headElement, "endColumn",false);
        	setMapIntegerByElementAttribute(head, headElement, "endRow",false);
        }
        
        /*读取className*/
        Element classNameElement = (Element)doc.selectSingleNode("excel-mapping-config/className");
        if (classNameElement == null)
        {
            throw new ExcelConfigException("在配置文件" + configFileName + "中没有找到excel-mapping-config/className结点!");
        }
        className=classNameElement.getTextTrim();
        if(className==null||className.length()==0)
        {
            throw new ExcelConfigException("在配置文件" + configFileName + "中结点excel-mapping-config/className没有设置内容!");
        }
        
        /*读取sheet*/
        Element sheetNode = (Element)doc.selectSingleNode("excel-mapping-config/sheet");
        if(sheetNode==null)
        {
           throw new ExcelConfigException("在配置文件" + configFileName + "中没有找到excel-mapping-config/sheet结点!");
        }
        sheetNameField=sheetNode.attributeValue("nameField");
        if(sheetNameField==null||sheetNameField.length()==0)
        {
            throw new ExcelConfigException("在配置文件" + configFileName + "中结点excel-mapping-config/sheet结点中的nameField属性没有设置内容!");
        }
        
        /*读取title*/
        Element titleElement = (Element) doc.selectSingleNode("excel-mapping-config/sheet/title");
        if (titleElement == null)
        {
             throw new ExcelConfigException("在配置文件" + configFileName + "中没有找到excel-mapping-config/sheet/title结点!");
        }
        setMapIntegerByElementAttribute(title, titleElement, "row",false);
        setMapIntegerByElementAttribute(title, titleElement, "height",true);
        setMapBooleanByElementAttribute(title, titleElement, "freeze",true);
        setMapBooleanByElementAttribute(title, titleElement, "checkTitleName",true);
        
        /*读取cell*/
        List cellList = doc.selectNodes("excel-mapping-config/sheet/title/cell");
        if(cellList==null)
        {
           throw new ExcelConfigException("在配置文件" + configFileName + "中没有找到excel-mapping-config/sheet/title/cell结点!");
        }
        for(Object obj:cellList)
        {
            Element cellElement=(Element)obj;
            Map<String,Object> cellMap=new HashMap<String,Object>();
            setMapIntegerByElementAttribute(cellMap, cellElement, "column",false);
            setMapStringByElementAttribute(cellMap, cellElement, "field",false);
            setMapIntegerByElementAttribute(cellMap, cellElement, "maxLength",true);
            setMapStringByElementAttribute(cellMap, cellElement, "type",true);
            setMapStringByElementAttribute(cellMap, cellElement, "format",true);
            setMapIntegerByElementAttribute(cellMap, cellElement, "width",true);
            cellMap.put("titleName",cellElement.getTextTrim());
            cells.add(cellMap);
        }
        
        /*读取data*/
        Element dataElement = (Element) doc.selectSingleNode("excel-mapping-config/sheet/data");
        if (dataElement == null)
        {
             throw new ExcelConfigException("在配置文件" + configFileName + "中没有找到excel-mapping-config/sheet/data结点!");
        }
        setMapIntegerByElementAttribute(data, dataElement, "begin",false);
        setMapIntegerByElementAttribute(data, dataElement, "end",true);
        setMapIntegerByElementAttribute(data, dataElement, "height",true);
    }

    /**
     * <p>
     * 取得EXCEL配置文件的一个结点元素的属性信息，校验它是否为整数，并存放在MAP中
     *
     * @param map             存储EXCEL配置文件信息
     * @param element         EXCEL配置文件的一个结点元素
     * @param attributeName   EXCEL配置文件的一个结点元素的属性名
     * @param isOptional      EXCEL配置文件的一个结点元素的属性是否为可选顶
     *
     * @throws ExcelConfigException  配置文件异常
     * </p>
     */
    private void setMapIntegerByElementAttribute(Map<String,Object> map, Element element, String attributeName,boolean isOptional) throws ExcelConfigException
    {
        String attributeValue = element.attributeValue(attributeName);
        if (attributeValue == null || attributeValue.trim().length() ==0)
        {
            if(!isOptional)
            {
               throw new ExcelConfigException("在配置文件" + configFileName + "中结点"+element.getName()+"的属性"+attributeName+"没有设置!");
            }
        }
        else
        {
            try
            {
            	map.put(attributeName, Integer.parseInt(attributeValue.trim()));
            }
            catch (NumberFormatException nfe)
            {
                throw new ExcelConfigException("在配置文件" + configFileName + "中结点"+element.getName()+"的属性"+attributeName+"不是Integer类型!");
            }
        }
    }

    /**
     * <p>
     * 取得EXCEL配置文件的一个结点元素的属性信息，并存放在MAP中
     *
     * @param map             存储EXCEL配置文件信息
     * @param element         EXCEL配置文件的一个结点元素
     * @param attributeName   EXCEL配置文件的一个结点元素的属性名
     * @param isOptional      EXCEL配置文件的一个结点元素的属性是否为可选顶
     *
     * @throws ExcelConfigException  配置文件异常
     * </p>
     */
    private void setMapStringByElementAttribute(Map<String,Object> map, Element element, String attributeName,boolean isOptional) throws ExcelConfigException
    {
        String attributeValue = element.attributeValue(attributeName);
        if (attributeValue == null || attributeValue.trim().length() ==0)
        {
            if(!isOptional)
            {
                throw new ExcelConfigException("在配置文件" + configFileName + "中结点"+element.getName()+"的属性"+attributeName+"没有设置!");
            }
        }
        else
        {
            map.put(attributeName,attributeValue.trim());
        }
    }
    
    /**
     * <p>
     * 取得EXCEL配置文件的一个结点元素的属性信息，校验它是否为Boolean，并存放在MAP中
     *
     * @param map             存储EXCEL配置文件信息
     * @param element         EXCEL配置文件的一个结点元素
     * @param attributeName   EXCEL配置文件的一个结点元素的属性名
     * @param isOptional      EXCEL配置文件的一个结点元素的属性是否为可选顶
     *
     * @throws ExcelConfigException  配置文件异常
     * </p>
     */
    private void setMapBooleanByElementAttribute(Map<String,Object> map, Element element, String attributeName,boolean isOptional) throws ExcelConfigException
    {
        String attributeValue = element.attributeValue(attributeName);
        if (attributeValue == null || attributeValue.trim().length() ==0)
        {
            if(!isOptional)
            {
               throw new ExcelConfigException("在配置文件" + configFileName + "中结点"+element.getName()+"的属性"+attributeName+"没有设置!");
            }
        }
        else
        {
        	map.put(attributeName, Boolean.valueOf((attributeValue.trim())));
        }
    }
}
