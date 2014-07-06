package cn.com.newcapec.citycard.account.dao;

import java.util.List;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.citycard.common.po.TOrgUser;

/**
 * <pre>
 * 功能描述:帐号管理DAO接口定义
 *   
 * Author : Wangjian 
 * Date   : 2008-05-05
 * Time   : 10:14:09
 * Version: 1.0
 * </pre>
 */
public interface IAccountDao
{
	/**
	 * 功能描述:取得指定帐号的用户信息
	 * 
	 * @param username 帐号
	 * 
	 * @return TOrgUser 用户信息
	 * */
    public TOrgUser getUserByUsername(String username);
    
    
    /**
     * 根据用户ID得到他是否在系统中已分配角色信息
     * @param userId
     * @return
     * @throws BusinessException
     */
    public Integer getRoleCountByUserId(Integer userId);
    /**
     * 根据用户ID得到所在部门(包括父级节点)的状态
     * @param userId
     * @return
     * @throws BusinessException
     */
    public Boolean getDepValid(Integer userId);
    /**
	 * 根据用户ID得到所在部门(包括父级节点)的IP登录信息
     * @param userId
     * @return
     * @throws BusinessException
     */
    public Boolean getIPAuth(Integer userId);
    /**
	 * 功能描述:得到用户可操作的模块
	 * 
	 * @param userId 用户ID号
	 * 
	 * @return NodeList 用户可操作的功能菜单结点列表
	 * */
    public List<Node> getNodeListByUserId(Integer userId);
    
}
