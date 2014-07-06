package cn.com.newcapec.common.upload.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.io.FileTransfer;

import cn.com.newcapec.common.upload.IuploadService;
import cn.com.newcapec.common.util.Constants;

/**
 * <p>Description: file upload</p>
 * @author Wangjian
 * @version 1.0
 */

public class UploadService implements IuploadService {
	/**  
	 * dwr 文件上传  
	 * @param ft  FileTransfer 封装类前台js提交的文件数据  
	 * @return  fileName
	 */
	public String uploadFile(FileTransfer ft) {
		WebContext wc = WebContextFactory.get();
		String headImages = wc.getSession().getServletContext().getRealPath(
				Constants.UPLOAD_PATH); // 获得应用路径

		File file = new File(headImages);

		// 如果文件夹不存在，就创建
		if (!file.exists()) {
			file.mkdirs();
		}

		String rtnName="";
		try {
			rtnName = generateFileName(ft.getName());
			org.apache.commons.io.FileUtils.copyInputStreamToFile(ft.getInputStream(), new File(
					headImages + File.separator + rtnName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnName;
	}
	
	//生成文件名
    private String generateFileName(String fileName){
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
        String formatDate = format.format(new Date());
        int random = new Random().nextInt(1000);   
        int position = fileName.lastIndexOf(".");   
        String extension = fileName.substring(position);   
        return formatDate + random + extension;   
    } 

}