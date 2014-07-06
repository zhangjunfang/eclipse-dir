package cn.com.newcapec.citycard.system.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.citycard.common.po.TLog;

import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * <pre>
 * 功能描述:用户操作日志导出Excel
 *   
 * Author : HouJiShuan 
 * Date   : 2008-06-22
 * Time   : 11:24:15
 * Version: 1.0
 * </pre>
 */
public class CreateExcel
{
	private static final String FILE_NAME = "系统操作日志.xls";  //导出的文件名称
	private static final String TITLE = "系统日志";          //文档的标题
	private static final String OPERATOR= "操作员";                //标头--操作员
	private static final String OPERATE_MODEL= "操作模块";          //标头--操作模块
	private static final String OPERATE_ACTION= "操作动作";         //标头--操作动作
	private static final String OPERATE_CONTENT= "操作内容";        //标头--操作内容
	private static final String IP= "IP地址";        //标头--操作内容
	private static final String OPERATE_DATE= "操作时间";           //标头--操作时间
	private static final String SHEET_NAME="操作日志";              //标头--操作日志
	private static final int TITLE_LENGTH = 2;                    //标题和表头占据的行数
	
	private WritableCellFormat wcfFieldName;               //标头字段格式
	private WritableCellFormat wcfTitle;                   //标题格式
	private WritableCellFormat wcfDate;                    //日期时间格式
	private WritableCellFormat wcfData_content;            //D列--操作内容--单元格格式
	private WritableWorkbook wwb;                          //可写工作簿
	private WritableSheet ws;                              //可写Sheet
	private OutputStream os;                               //输出流
	 
	/**
	 * 构造器
	 * 初始化工作簿和Sheet
	 * */
	public CreateExcel(){
		InitWorkbookSheet();  //初始化--工作簿和Sheet 
	}
	
	/**
	 * 输出信息到Excel模板中
	 * @param list 查询出来的列表
	 * void
	 */
	public void writeDataToExcel(List list) throws Exception{
		try{
			setCellFormat();  //设置--单元格格式
			setSheetFormat(); //设置--Sheet格式
			if(null != list)
			{
				/*循环写入数据*/
				for(int i=0; i<list.size(); i++)
				{
					TLog logInfo = (TLog)list.get(i);
					int j = logInfo.getLogContent().length()/55;
					if(j>0) //判断操作内容的长度如果大于55则对应的行高变为默认高度的相近偶数倍
					{
						if(j%2>0)
						ws.setRowView(TITLE_LENGTH+i, ws.getRowView(TITLE_LENGTH+i).getSize()*(j+1));
						else
							ws.setRowView(TITLE_LENGTH+i, ws.getRowView(TITLE_LENGTH+i).getSize()*j);
					}
					ws.addCell(new Label(0,TITLE_LENGTH+i,logInfo.getOperator()));                //A
					ws.addCell(new Label(1,TITLE_LENGTH+i,logInfo.getModule()));                   //B
					ws.addCell(new Label(2,TITLE_LENGTH+i,logInfo.getAction()));                  //C    
					ws.addCell(new Label(3,TITLE_LENGTH+i,logInfo.getLogContent(),wcfData_content)); //D
					ws.addCell(new Label(4,TITLE_LENGTH+i,logInfo.getIp())); //D
					ws.addCell(new DateTime(5,TITLE_LENGTH+i,logInfo.getLogDate(),wcfDate));      //E
				}//for-end
			}//if-end
			wwb.write();
		}catch(WriteException e)
		{
			e.printStackTrace();
		}finally
		{
			wwb.close();    //关闭--可写工作簿
			if(null != os)
			{
				os.close(); //关闭--输出流
			}
		}
	}
	
	/**
	 * 设置单元格格式
	 * void
	 *  
	 */
	private void setCellFormat() throws Exception{
	 	try {
	 		/*标题单元格格式定义：黑体、28号、粗体、黑色字、居中显示、无底色、无边框*/
	 		WritableFont wfTitle=new WritableFont(WritableFont.createFont("黑体"),28,WritableFont.BOLD);  //定义--标题字体格式

    		wcfTitle =new WritableCellFormat(wfTitle);                           //添加--单元格字体格式
			wcfTitle.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);  //设置--单元格垂直居中格式
			wcfTitle.setAlignment(jxl.format.Alignment.CENTRE);                  //设置--单元格水平局址格式
			
    		/*字段名称单元格格式定义：宋体、14号、粗体、黑色字、居中显示、淡紫底色、无边框*/
			WritableFont wfFieldName=new WritableFont(WritableFont.createFont("宋体"),14,WritableFont.BOLD); //定义--字段名称字体格式

			wcfFieldName =new WritableCellFormat(wfFieldName);                       //添加--单元格字体格式
			wcfFieldName.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);  //设置--单元格垂直居中格式
			wcfFieldName.setAlignment(jxl.format.Alignment.CENTRE);                  //设置--单元格水平居中格式
			wcfFieldName.setBackground(jxl.format.Colour.ICE_BLUE);                  //设置--单元格底色为淡紫色
			
			/*填充区数据格式：设置日期时间格式*/
			jxl.write.DateFormat dateFormat = new jxl.write.DateFormat("yyyy-MM-dd HH:mm:ss"); //定义--日期时间格式
			wcfDate = new WritableCellFormat(dateFormat);
			wcfData_content = new WritableCellFormat();
			wcfData_content.setWrap(true);   //设置--单元格格式--换行
		} catch (RowsExceededException e) {
			throw e;
		}
	}
	
	/**
	 * 设置Sheet格式:列宽、行高；
	 * 添加：标题、标头
	 */
	private void setSheetFormat() throws Exception{
		try{ 
			/*设置列宽-开始*/
			ws.setColumnView(0, 12); //A
			ws.setColumnView(1, 45); //B
			ws.setColumnView(2, 12); //C
			ws.setColumnView(3, 70); //D
			ws.setColumnView(4, 20); //E
			ws.setColumnView(5, 20); //E
			/*设置列宽-结束*/
			
			/*设置行高-开始*/
			ws.mergeCells(0,0,5,0); //单元格合并：将第1行合并前5列，行列默认都是从0开始的
			ws.setRowView(0, 800);  //设置--第一行行高
			ws.setRowView(1, 400);  //设置--第二行行高
			ws.getSettings().setVerticalFreeze(2);    //从第三行--冻结窗口
			/*设置行高-结束*/
			
			/*标题、标头部分-开始*/
			ws.addCell(new Label(0,0,TITLE,wcfTitle));               //添加标题
			ws.addCell(new Label(0,1,OPERATOR,wcfFieldName));        //添加标头--操作员
			ws.addCell(new Label(1,1,OPERATE_MODEL,wcfFieldName));   //添加标头--操作模块
			ws.addCell(new Label(2,1,OPERATE_ACTION,wcfFieldName));  //添加标头--操作动作
			ws.addCell(new Label(3,1,OPERATE_CONTENT,wcfFieldName)); //添加标头--操作内容
			ws.addCell(new Label(4,1,IP,wcfFieldName)); 			 //添加标头--IP地址
			ws.addCell(new Label(5,1,OPERATE_DATE,wcfFieldName));    //添加标头--操作日期
			/*标题、标头部分-结束*/
		}catch (WriteException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化工作簿、Sheet、输出流
	 * */
	private void InitWorkbookSheet(){
		try
		{
			os = getOutPutStream(FILE_NAME);       //初始化--输出流
			wwb= jxl.Workbook.createWorkbook(os); //创建--可操作的工作簿
			ws=wwb.createSheet(SHEET_NAME, 0);    //初始化--Sheet
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}  
	}
	
	/**
	 * 设置输出流，返回输出流对象
	 *
	 * @param  fileName
	 * @return OutputStream
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private OutputStream getOutPutStream(String fileName) throws IOException,UnsupportedEncodingException {
			HttpServletResponse response=ServletActionContext.getResponse();
			OutputStream os = response.getOutputStream();
			fileName=new String(fileName.getBytes("GBK"),"iso8859-1");
			response.reset();// 清空输出流
			response.setContentType("application/X-msdownload;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename="+fileName);
			response.setContentType("application/vnd.ms-excel");
			return os;
	}

}
