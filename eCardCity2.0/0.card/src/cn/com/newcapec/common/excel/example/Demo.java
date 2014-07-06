package cn.com.newcapec.common.excel.example;

import cn.com.newcapec.common.excel.service.ExcelCreate;
import cn.com.newcapec.common.excel.service.ExcelMappingConfig;
import cn.com.newcapec.common.excel.service.ExcelParse;
import cn.com.newcapec.common.excel.util.DateHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 功能描述:解析EXCEL文件DEMO
 *   
 * Author : Wangjian 
 * Date   : 2007-11-16
 * Time   : 18:43:34
 * Version:1.0
 * </pre>
 */
public class Demo
{
	private String cfgFile="/excel/exampleExcelMappingConfig.xml";
	private String objFile="D:\\example.xls";
	public Demo(int LEN)
	{
		try
		{
            ExcelMappingConfig cfg=new ExcelMappingConfig(cfgFile);
            List<Example> objList=new ArrayList<Example>(LEN);
			for(int i=0;i<LEN;i++)
			{
				Example example=new Example();
				example.setId(i+1D);
				example.setName("闹市隐侠"+i);
				example.setAge(i+100D);
				example.setBirthday(DateHelper.parseDate("1900-01-01", DateHelper.SHORT_DATE_FORMAT));
				example.setSalary(1000D);
				example.setBonus(100D);
				example.setStatDate(new Date());
				example.setRemark("孤剑寒芒，流光化星雨，独行万里，为有破天时。创意未来，豪气塞寰宇，业经风雨，微笑顾心志。");
				objList.add(example);
			}
            File file=new File(objFile);
			ExcelCreate ec=new ExcelCreate(cfg);
			ec.createExcel(objList,"测试数据", file);
            
			ExcelParse ep=new ExcelParse(cfg);
			List<Map<String,Object>> list=ep.parseExcelAndHead(file);
			for(Map<String,Object> map:list)
			{
				System.out.println("标题:"+map.get(ExcelParse.HEAD));
				for(Object obj:(List)map.get(ExcelParse.CONTENT))
                {
                    System.out.println(obj);
                }
            }
		}
		catch (Exception e) 
		{
            e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		long startTime=System.currentTimeMillis();
		new Demo(10000);
		long endTime=System.currentTimeMillis();
		System.out.println("共用了"+(endTime-startTime)+"ms!");
	}
}
