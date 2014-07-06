package cn.com.newcapec.common.util;
/**
 * <p>
 * 功能描述:系统全局常量定义
 *   
 * Author : Wangjian 
 * Date   : 2007-10-11 
 * Time   : 18:17:46 
 * Version:1.0
 * </p>
 */
public interface Constants {
	public static final String PICTURE_PHARMACY = "1";				//图片类别-
	public static final String PICTURE_MEDICINE = "2";				//图片类别-
	
	public static final String CONTENT_BULLETIN = "系统公告";			
	public static final Integer CONTENT_BULLETIN_ID = 2;			//公告ID
	
	public static final String INFO_US_COMPANY = "公司简介";			//关于我们-公司简介
	public static final Integer INFO_US_COMPANY_ID = 31;			//关于我们-公司简介ID
	public static final String INFO_US_CONTACT = "联系我们";			//关于我们-联系我们
	public static final Integer INFO_US_CONTACT_ID = 32;			//关于我们-联系我们ID
	public static final String INFO_WGJS = "网购警示";				//消费者保障
	public static final Integer INFO_WGJS_ID = 41;					//消费者保障
	public static final String INFO_YSBH = "隐私保护";				//消费者保障
	public static final Integer INFO_YSBH_ID = 42;					//消费者保障
	public static final String INFO_TSWQ = "投诉维权";				//消费者保障
	public static final Integer INFO_TSWQ_ID = 43;					//消费者保障
	public static final String INFO_KFZX = "客服中心";				//消费者保障
	public static final Integer INFO_KFZX_ID = 44;					//消费者保障
	public static final String INFO_CJWT = "常见问题";				//新手帮助
	public static final Integer INFO_CJWT_ID = 51;					//新手帮助
	public static final String INFO_SPSS = "商品搜索";				//新手帮助
	public static final Integer INFO_SPSS_ID = 52;					//新手帮助
	public static final String INFO_THH = "退换货保障";				//售后服务
	public static final Integer INFO_THH_ID = 61;					//售后服务
	public static final String INFO_GYS = "供应商指南";				//供应商指南
	public static final Integer INFO_GYS_ID = 71;					//供应商指南
	
	public static final String ACT_ADD = "add";						//action为添加
	public static final String ACT_UPDATE = "update";				//action为修改

	public static final String VIEW_SUCCESS = "viewSuccess";		//查看成功跳转
	public static final String LIST_SUCCESS = "listSuccess";		//列表成功跳转
	public static final String EDIT_PRE_SUCCESS = "editPreSuccess";	//修改记录前成功跳转
	public static final String EDIT_SUCCESS = "editSuccess";		//修改成功跳转
	public static final String LIST_FAILURE = "listFailure";		//列表失败跳转
	public static final String EDIT_PRE_FAILURE = "editPreFailure";	//修改记录前失败跳转
	public static final String EDIT_FAILURE = "editFailure";		//修改失败跳转
	public static final String RECORD_DEL = "1"; // 记录删除的标记
	public static final String RECORD_DEL_NOT = "0";// 记录未删除的标记
	public static final String PREPARATION = "预留"; // 设备管理地址-预留
	public static final String SESSION_USER = "user";// 登录系统后session中保存的用户信息
	public static final String SESSION_MENU = "menu";// 登录系统后session中保存菜单信息
	public static final String SESSION_MEMBER = "member";// 登录系统后session中保存的会员信息
	public static final Integer MIN_PAGE_NUM = 10;// 分页时最小每页记录总数

	public static final String STATE_VALID = "1";	//状态，有效
	public static final String STATE_INVALID = "0";	//状态，有效

	//分页时默认每页记录总数, 在配置文件page.properties中page.config.pageListNum定义
	public static final Integer DEFAULT_PAGE_NUM = 0;
	public static final Integer MAX_PAGE_NUM = 50;// 分页时最大每页记录总数
	public static final String VERTICAL_BAR = "|";// 竖杠
	public static final String HORIZONTAL_BAR = "-";// 横杠
	public static final String UNDERLINE = "_";// 下划线
	public static final String BLANK_SPACE = " ";// 空格
	public static final String SLASH = "/";// 斜杠
	public static final String BACKLASH = "\\";// 反斜杠
	public static final String BRACKET_LEFT_BIG = "{";// 左大括号
	public static final String BRACKET_RIGHT_BIG = "}";// 右大括号
	public static final String BRACKET_LEFT_MIDDLE = "[";// 左中括号
	public static final String BRACKET_RIGHT_MIDDLE = "]";// 右中括号
	public static final String BRACKET_LEFT_SMALL_EN = "(";// 左小括号(英文)
	public static final String BRACKET_RIGHT_SMALL_EN = ")";// 右小括号(英文)
	public static final String BRACKET_LEFT_SMALL_ZH = "（";// 左小括号(中文)
	public static final String BRACKET_RIGHT_SMALL_ZH = "）";// 右小括号(中文)
	public static final String ARROW_KEY = "->";// 箭头
	public static final String COLON_EN = ":";// 冒号(英文)
	public static final String COLON_ZH = "：";// 冒号(中文)
	public static final String COMMA = ",";// 逗号
	public static final String POINT = ".";// 点
	public static final String HN = "HA";// 河南省缩写
	public static final String HENAN = "河南";// 河南省
	public static final String ZHENGZHOU = "郑州";// 郑州
	public static final String ERROR_PROMPT = "出错了,请与系统管理员联系!";// 错误提示
	public static final String ERROR_RAND_NO_VALID = "验证码失效！";// 错误提示
	public static final String ERROR_RAND_BLANK = "验证码不能为空！";// 错误提示
	public static final String ERROR_RAND_VALIDATE = "验证码填写错误，请重新输入！";// 错误提示

	public static final String UPLOAD_PATH = "/userfiles-system";	//上传文件路径

}
