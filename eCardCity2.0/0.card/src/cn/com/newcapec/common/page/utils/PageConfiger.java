package cn.com.newcapec.common.page.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PageConfiger
{
	public static int NO_PAGE_LIST_NUM = 0;
	
	private static PageConfiger instance = null;
	
	private static String CONFIG_FILENAME = "/config/page.properties";
	private static String EXCEPT_PARAMETERS="page.config.exceptParameters";
	private static String PAGE_LIST_NUM="page.config.pageListNum";
	
	private Properties props = new Properties();
	private List<String> exceptParameterList=new ArrayList<String>();
	private int pageListNum = 0;


	private PageConfiger()
	{
		try
		{
			props.load(getClass().getResourceAsStream(CONFIG_FILENAME));
		}
		catch (Exception e)
		{
			System.err.println("在CLASSPATH根目录下没找到文件page.properties!");
		}	
		String exceptParameter = props.getProperty(EXCEPT_PARAMETERS);
		if (exceptParameter != null && exceptParameter.trim().length()>0)
		{
			String[] tmps = exceptParameter.split(",");
			for (String tmp:tmps)
			{
				if(tmp.trim().length()>0)
				{
					exceptParameterList.add(tmp.trim());
				}
			}
		}
		String tmpPageListNum = props.getProperty(PAGE_LIST_NUM);
		if (tmpPageListNum != null && tmpPageListNum.trim().length()>0)
		{
			try
			{
				this.pageListNum = Integer.valueOf(tmpPageListNum.trim());
			}
			catch (Exception e)
			{
				System.err.println("在page.properties中page.config.pageListNum不是数字!");
			}
		}
	}

	public static PageConfiger getInstance()
	{
		if (instance == null) 
			instance = new PageConfiger();
		return instance;
	}

	public String getProperty(String key)
	{
		return props.getProperty(key);
	}
	public List getExceptParameterList()
	{
		return exceptParameterList;
	}

	public int getPageListNum()
	{
		return pageListNum;
	}
}
