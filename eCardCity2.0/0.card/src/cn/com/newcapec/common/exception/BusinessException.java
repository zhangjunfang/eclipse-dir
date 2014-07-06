package cn.com.newcapec.common.exception;

/**
 * <pre>
 * 功能描述:业务逻辑异常
 *   
 * Author : Wangjian 
 * Date	  : 2007-11-07
 * Time   : 17:17:15
 * Version:1.0
 * </pre>
 */
public class BusinessException extends Exception
{
	private static final long serialVersionUID = 4971549879789103490L;

	public BusinessException()
	{
		this("业务逻辑异常!");
	}

	public BusinessException(String message)
	{
		super(message);
	}

	public BusinessException(Throwable cause)
	{
		super(cause);
	}

	public BusinessException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
