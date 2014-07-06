package cn.com.newcapec.common.excel.exception;

/**
 * <pre>
 * 功能描述:解析Excel运行时异常
 *   
 * Author : Wangjian 
 * Date   : 2007-11-14 
 * Time   : 10:07:00
 * Version: 1.2
 * </pre>
 */
public class ExcelParseException  extends Exception
{
	private static final long serialVersionUID = -3843490135899784494L;

	public ExcelParseException()
    {
        this("解析Excel运行时异常!");
    }

    public ExcelParseException(String message)
    {
        super(message);
    }

    public ExcelParseException(Throwable cause)
    {
        super(cause);
    }

    public ExcelParseException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
