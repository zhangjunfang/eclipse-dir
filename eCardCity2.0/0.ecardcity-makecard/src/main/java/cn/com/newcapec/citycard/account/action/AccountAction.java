package cn.com.newcapec.citycard.account.action;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.common.util.HttpServletHelper;
import cn.com.newcapec.common.util.RandomNumUtil;
import com.opensymphony.xwork2.ActionContext;
import cn.com.newcapec.citycard.account.domain.Account;
import cn.com.newcapec.citycard.account.service.IAccountService;
import cn.com.newcapec.citycard.common.action.CommonAction;
import cn.com.newcapec.citycard.common.po.TOrgUser;

/**
 * <p>
 * 功能描述:登录注销
 * 2013-09-23修改，增加状态和IP登录规则  
 * Author : Wangjian 
 * Date   : 2012-12-04
 * Time   : 17:03:15
 * Version: 1.0
 * </p>
 */
public class AccountAction extends CommonAction {
	private static final long serialVersionUID = -2629485179336747168L;
	private ByteArrayInputStream inputStream;// 验证码输出流
	private IAccountService accountService;// 帐号管理服务接口
	private TOrgUser user; // 保存用户信息的类
	private String newPwd; // 新密码
	private String dept; // 部门

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	private Account account;// 用户帐号

	public Account getAccount() {
		return account;
	}

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the user
	 */
	public TOrgUser getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(TOrgUser user) {
		this.user = user;
	}

	/**
	 * <p>
	 * 生成验证码
	 * </p>
	 */
	public String generate() throws Exception {
		RandomNumUtil rdnu = RandomNumUtil.Instance();
		setInputStream(rdnu.getImage());// 取得带有随机字符串的图片
		ActionContext.getContext().getSession().put("random", rdnu.getString());// 取得随机字符串放入HttpSession
		HttpServletHelper.setSessionValue(ActionContext.getContext(), "random",
				rdnu.getString());
		return "generate_success";
	}

	/**
	 * <p>
	 * 登录
	 * 
	 * 成功,进入系统
	 * 失败，返回登录页面
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public String login() throws Exception {
		if (account == null) {
			return ERROR;
		}

		// 验证码
		String arandom = (String) HttpServletHelper.getSessionValue(
				ActionContext.getContext(), "random");
		if (StringUtils.isBlank(arandom)) {
			account.setPrompt(Constants.ERROR_RAND_NO_VALID);
			return ERROR;
		} else if (StringUtils.isBlank(account.getRand())) {
			account.setPrompt(Constants.ERROR_RAND_BLANK);
			return ERROR;
		} else if (!arandom.equals(account.getRand())) {
			account.setPrompt(Constants.ERROR_RAND_VALIDATE);
			return ERROR;
		}

		// 身份验证&&模块读取
		List<Node> nodeList = null;
		try {
			user = accountService.validateAccount(account.getUsername(),
					account.getPassword());
			nodeList = accountService.getNodeListByUserId(user.getId());
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e.getCause());
			}
			if (e instanceof BusinessException) {
				account.setPrompt(e.getMessage());
			} else {
				account.setPrompt(Constants.ERROR_PROMPT);
			}
			return ERROR;
		}

		// 保存登录信息
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put(Constants.SESSION_MENU, nodeList);
		session.put(Constants.SESSION_USER, user);
		return "login_success";
	}

	/**
	 * <p>
	 * 注销，返回登录页面
	 * </p>
	 */
	public String logout() throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout_success";
	}

	// 修改自身用户信息--取最新用户信息
	public String updateSelfPre() throws Exception {
		try {
			user = accountService.getUserByPk(((TOrgUser) getSession()
					.getAttribute(Constants.SESSION_USER)).getId());
			setDept(user.getDept().getDeptName());
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "updateSelfPage";
	}

	// 修改自身用户密码--取最新用户信息
	public String updatePwdPre() throws Exception {
		try {
			user = accountService.getUserByPk(((TOrgUser) getSession()
					.getAttribute(Constants.SESSION_USER)).getId());
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "updatePwdPage";
	}

	// 修改自身用户信息
	public String updateSelf() throws Exception {
		// 添加日志，动作/内容/模块/用户
		try {
			logInfo.setAction((String) logAction.getDatas().get("UPDATE"));
			logInfo.setLogContent(logInfo.getAction() + "：“"
					+ user.getUserName() + "”用户修改了自己的用户信息。");
			logInfo.setModule((String) logModule.getDatas().get(
					"SYSTEM_ADMIN_ORG")
					+ "_个人信息管理");
			accountService.updateUser(user);
			logInfoService.saveTLog(logInfo);
			getSession().setAttribute(Constants.SESSION_USER, user);
			prompt = "用户信息修改成功！";
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
			prompt = "修改失败，原因：" + e.getMessage();// 页面显示消息
			return "updateSelfPage";
		}
		return "updateSelfPage";
	}

	// 修改自身用户密码
	public String updatePwd() throws Exception {
		// 添加日志，动作/内容/模块/用户
		try {
			// 验证原有密码是否正确
			if (accountService.checkPasswordSame(user.getPassword(),
					accountService.getUserByPk(user.getId()).getPassword())) {
				logInfo.setAction((String) logAction.getDatas().get("UPDATE"));
				logInfo.setLogContent(logInfo.getAction() + "：“"
						+ user.getUserName() + "”用户修改了自己的密码。");
				logInfo.setModule((String) logModule.getDatas().get(
						"SYSTEM_ADMIN_ORG")
						+ "_个人信息管理");
				user.setPassword(newPwd);
				accountService.updateUser(user);
				logInfoService.saveTLog(logInfo);
				getSession().setAttribute(Constants.SESSION_USER, user);
				prompt = "用户密码修改成功！";
			} else {
				prompt = "输入的旧密码不正确！";
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
			prompt = "修改失败，原因：" + e.getMessage();// 页面显示消息
			return "updatePwdPage";
		}
		return "updatePwdPage";
	}
}
