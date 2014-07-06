package cn.com.newcapec.citycard.account.service.impl;

import java.util.List;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.service.impl.BaseService;
import cn.com.newcapec.common.util.StringHelper;
import cn.com.newcapec.citycard.account.dao.IAccountDao;
import cn.com.newcapec.citycard.account.service.IAccountService;
import cn.com.newcapec.citycard.common.po.TOrgUser;

/**
 * <p>
 * 功能描述:帐号管理服务接口实现
 *   
 * Author : Wangjian 
 * Date   : 2008-05-05
 * Time   : 09:52:05
 * Version: 1.0
 * </p>
 */
public class AccountService extends BaseService implements IAccountService{
	private IAccountDao accountDao;//帐号管理DAO接口

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * @return the accountDao
	 */
	public IAccountDao getAccountDao() {
		return accountDao;
	}

	/**
	 * 功能描述:校验用户帐号
	 * 
	 * @param username 帐号
	 * @param password 密码
	 * 
	 * @return User 用户
	 * 
	 * @throws BusinessException 业务异常
	 * */
	public TOrgUser validateAccount(String username, String password)
			throws BusinessException {
		if (username == null || username.length() == 0) {
			throw new BusinessException("用户名不能为空!");
		}
		if (password == null || password.length() == 0) {
			throw new BusinessException("密码不能为空!");
		}
		TOrgUser euser = accountDao.getUserByUsername(username);
		if (euser == null) {
			throw new BusinessException("该帐号不存在!");
		}
		/**
		 * 对密码进行MD5加密后进行与数据库中存储密码的比较
		 */
		String spassword = null;
		try {
			spassword = StringHelper.convertToMd5(password);
		} catch (Exception e) {
			throw new BusinessException("密码格式转换失败!");
		}

		if (!spassword.equals(euser.getPassword())) {
			throw new BusinessException("密码不正确!");
		}
		if (euser.getValid() != null && euser.getValid().equals("0")) {
			throw new BusinessException("该帐号已被禁用,请与系统管理员联系!");
		}
		if (getRoleCountByUserId(euser.getId()) == 0) {
			throw new BusinessException("该帐号没有分配角色,请与系统管理员联系!");
		}
		if (!getValidByUserId(euser.getId())) {
			throw new BusinessException("该账号所在组织机构已被禁止登录,或超过有效期限!");
		}
		if (!getIPByUserId(euser.getId())) {
			throw new BusinessException("该账号登录IP不在组织机构许可IP地址范围内!");
		}
		return euser;
	}

	/**
	 * 根据用户ID得到他是否在系统中已分配角色信息
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public Integer getRoleCountByUserId(Integer userId)
			throws BusinessException {
		return accountDao.getRoleCountByUserId(userId);
	}
	
	/**
	 * 根据用户ID得到所在部门(包括父级节点)的状态
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public Boolean getValidByUserId(Integer userId)
			throws BusinessException {
		return accountDao.getDepValid(userId);
	}
	
	/**
	 * 根据用户ID得到所在部门(包括父级节点)的IP登录信息
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public Boolean getIPByUserId(Integer userId)
			throws BusinessException {
		return accountDao.getIPAuth(userId);
	}

	/**
	 * 功能描述:得到用户可操作的模块
	 * 
	 * @param userId 用户ID号
	 * 
	 * @return NodeList 用户可操作的功能菜单结点列表
	 * 
	 * @throws BusinessException 业务异常
	 * */
	public List<Node> getNodeListByUserId(Integer userId)
			throws BusinessException {
		assert userId != null;
		return accountDao.getNodeListByUserId(userId);
	}
	
	/* (non-Javadoc)
	 * @see cn.com.newcapec.citycard.account.service.impl.AccountService#getUserByPk(java.lang.Integer)
	 */
	public TOrgUser getUserByPk(Integer userId) throws BusinessException{
		assert userId != null;
		return (TOrgUser)baseDao.get(TOrgUser.class, userId);
	}
	
	/**
	 * 功能描述:获取用户信息
	 * @param userId 用户ID
	 * @return TOrgUser
	 * @throws Exception 
	 * 
	 */
	public void updateUser(TOrgUser user) throws Exception{
		assert user != null;
		if(!getUserByPk(user.getId()).getPassword().equals(user.getPassword())){
			user.setPassword(StringHelper.convertToMd5(user.getPassword()));
		}
		baseDao.merge(user);
	}
	
	
	/**
	 * 功能描述:监测输入的旧密码是否正确
	 * 
	 * @param pwdInput	输入的，未经加密的
	 * @param pwdDB		数据库的，已经加密的
	 * @return Boolean
	 * @throws BusinessException 
	 */
	public boolean checkPasswordSame(String pwdInput,String pwdDB) throws Exception{
		return StringHelper.convertToMd5(pwdInput).equals(pwdDB);
	}
}
