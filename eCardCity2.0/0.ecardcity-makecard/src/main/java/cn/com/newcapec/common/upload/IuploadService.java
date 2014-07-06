package cn.com.newcapec.common.upload;

import org.directwebremoting.io.FileTransfer;

public interface IuploadService {

	/**  
	 * dwr 文件上传  
	 * @param ft  FileTransfer 封装类前台js提交的文件数据  
	 * @return  fileName
	 */
	public String uploadFile(FileTransfer ft);

}
