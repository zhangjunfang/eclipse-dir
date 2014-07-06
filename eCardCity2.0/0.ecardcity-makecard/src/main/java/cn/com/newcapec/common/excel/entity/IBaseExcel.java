package cn.com.newcapec.common.excel.entity;

/**
 * <p>
 * 功能描述:EXCEL公共接口
 *   
 * Author : Wangjian 
 * Date   : 2007-11-14
 * Time   : 13:31:57
 * Version: 1.2
 * </p>
 */
public interface IBaseExcel
{
	/**
     * 校验必填字段是否全部为空，若是返回true；否则返回false
     *
     * @return boolean
     * */
    public boolean isAllFieldNull();


    /**
     * 若必填字段不是全部为空,则校验数据是否合法，若是返回true；否则返回false
     *
     * @return boolean
     * */
    public boolean validate();

    /**
     * 若数据不合法,返回错误提示
     *
     * @return String
     * */
    public String getErrorPrompt();
}
