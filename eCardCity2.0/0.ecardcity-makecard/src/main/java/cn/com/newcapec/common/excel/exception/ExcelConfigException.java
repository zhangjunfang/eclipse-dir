package cn.com.newcapec.common.excel.exception;

/**
 * <p>
 * 功能描述:Excel映射文件配置异常
 *   
 * Author : Wangjian 
 * Date   : 2007-11-14 
 * Time   : 09:07:00
 * Version: 1.2
 * </p>
 */
public class ExcelConfigException extends Exception
{
	private static final long serialVersionUID = 1530951136397687925L;

	public ExcelConfigException()
    {
        this("Excel映射文件配置异常!");
    }

    public ExcelConfigException(String message)
    {
        super(message);
    }

    public ExcelConfigException(Throwable cause)
    {
        super(cause);
    }

    public ExcelConfigException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
