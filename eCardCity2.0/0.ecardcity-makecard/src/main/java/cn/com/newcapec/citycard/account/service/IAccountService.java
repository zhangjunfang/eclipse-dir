package cn.com.newcapec.citycard.account.service;

import java.util.List;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.citycard.common.po.TOrgUser;

/**
 * <p>
 * 功能描述: 帐号管理服务接口定义
 *   
 * Author : Wangjian 
 * Date   : 2008-05-05
 * Time   : 09:37:05
 * Version: 1.0
 * </p>
 */
public interface IAccountService
{
	/**
	 * 功能描述:获取用户信息
	 * @param userId 用户ID
	 * @return TOrgUser
	 * 
	 */
	public TOrgUser getUserByPk(Integer userId) throws BusinessException;

	/**
	 * 功能描述:校验用户帐号
	 * 
	 * @param username 帐号
	 * @param password 密码
	 * 
	 * @return TOrgUser 用户
	 * 
	 * @throws BusinessException 业务异常
	 * */
    public TOrgUser validateAccount(String username, String password) throws BusinessException;
    
    
    /**
	 * 功能描述:得到用户可操作的模块
	 * 
	 * @param userId 用户ID号
	 * 
	 * @return NodeList 用户可操作的功能菜单结点列表
	 * 
	 * @throws BusinessException 业务异常
	 * */
    public List<Node> getNodeListByUserId(Integer userId) throws BusinessException;

	/**
	 * 功能描述:获取用户信息
	 * @param userId 用户ID
	 * @return TOrgUser
	 * 
	 */
	public void updateUser(TOrgUser user) throws Exception;

	/**
	 * 功能描述:监测输入的旧密码是否正确
	 * 
	 * @param pwdInput	输入的，未经加密的
	 * @param pwdDB		数据库的，已经加密的
	 * @return Boolean
	 * @throws Exception 
	 */
	public boolean checkPasswordSame(String pwdInput, String pwdDB)
			throws Exception;

}
