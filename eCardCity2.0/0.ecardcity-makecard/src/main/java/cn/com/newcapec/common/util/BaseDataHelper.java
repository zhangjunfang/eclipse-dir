package cn.com.newcapec.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.com.newcapec.common.exception.BusinessException;

/**
 * <p>
 * 功能描述:字典数据解析工具
 *   
 * Author : Wangjian 
 * Date   : 2008-05-09
 * Time   : 17:44:15
 * Version: 1.0
 * </p>
 */
public class BaseDataHelper
{
	private static final String DATA_PATH="datas/data";
	private static final String KEY="key";
	private static final String VALUE="value";
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private final InputStream is; //输入流
	
	private final String configFileName;//配置文件名称
	
	private Map<String,String> datas=new TreeMap<String,String>();//数据集
	
	public Map<String, String> getDatas()
	{
		return datas;
	}

	/**
     * <p>
     * 解析配置文件
     *
     * @param configFilePath  配置文件路径
     *                        以"/"开始的,是相对于classpath根目录的路径;
     *                        否则相对于本文件所在目录的路径
     *
     * @throws BusinessException 配置异常
     * </p>
     */
	public BaseDataHelper(String configFilePath) throws BusinessException
	{
		if(configFilePath==null)
		{
			throw new BusinessException("没有初始化配置文件路径");
		}
		try
		{
			is=getClass().getResourceAsStream(configFilePath);
		}
		catch (Exception e)
		{
			if(log.isDebugEnabled())
			{
				log.debug(e.getMessage());
			}
			throw new BusinessException("配置文件路径不正确");
		}
		configFileName=configFilePath;
		init();
	}
	
	/**
     * <p>
     * 解析配置文件
     *
     * @param configFile      配置文件
     *
     * @throws BusinessException 配置异常
     * </p>
     */
	public BaseDataHelper(File configFile) throws BusinessException
	{
		if(configFile==null)
		{
			throw new BusinessException("没有初始化配置文件");
		}
		try
		{
			is=new FileInputStream(configFile);
		}
		catch (Exception e)
		{
			if(log.isDebugEnabled())
			{
				log.debug(e.getMessage());
			}
			throw new BusinessException("配置文件路径不正确");
		}
		configFileName=configFile.getName();
		init();
	}
	
	/**
     * <p>
     * 解析
     *
     * @throws BusinessException 配置异常
     * </p>
     */
	private void init() throws BusinessException
	{
		SAXReader saxReader = new SAXReader();
        Document doc;
        try
        {
            doc = saxReader.read(is);
        }
        catch (Exception e)
        {
        	if(log.isDebugEnabled())
			{
				log.debug(e.getMessage());
			}
        	throw new BusinessException("无法解析配置文件"+configFileName);
        }
        
        List dataList = doc.selectNodes(DATA_PATH);
        if(dataList==null)
        {
        	return;
        }
        
        datas=new TreeMap<String,String>();
        
        for(Object obj:dataList)
        {
        	Element data=(Element)obj;
        	Element keyElement=(Element)data.selectSingleNode(KEY);
        	if(keyElement==null)
        	{
        		throw new BusinessException("配置文件"+configFileName+"缺少"+KEY+"结点");
        	}
        	String key=keyElement.getTextTrim();
        	if(key.length()==0)
        	{
        		throw new BusinessException("配置文件"+configFileName+"结点"+KEY+"值为空");
        	}
        	if(datas.containsKey(key))
        	{
        		throw new BusinessException("配置文件"+configFileName+"结点"+KEY+"值"+key+"重复");
        	}
        	Element valueElement=(Element)data.selectSingleNode(VALUE);
        	if(valueElement==null)
        	{
        		throw new BusinessException("配置文件"+configFileName+"缺少"+VALUE+"结点");
        	}
        	String value=valueElement.getTextTrim();
        	if(value.length()==0)
        	{
        		throw new BusinessException("配置文件"+configFileName+"结点"+VALUE+"值为空");
        	}
        	datas.put(key, value);
        }
	}
}
