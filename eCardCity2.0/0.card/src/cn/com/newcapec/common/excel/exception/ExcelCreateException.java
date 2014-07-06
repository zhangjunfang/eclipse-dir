package cn.com.newcapec.common.excel.exception;

/**
 * <pre>
 * 功能描述:生成Excel运行时异常
 *   
 * Author : Wangjian 
 * Date   : 2007-11-14 
 * Time   : 10:07:00
 * Version: 1.2
 * </pre>
 */
public class ExcelCreateException extends Exception
{
	private static final long serialVersionUID = 4076793889391373639L;

	public ExcelCreateException()
    {
        this("生成Excel运行时异常!");
    }

    public ExcelCreateException(String message)
    {
        super(message);
    }

    public ExcelCreateException(Throwable cause)
    {
        super(cause);
    }

    public ExcelCreateException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
