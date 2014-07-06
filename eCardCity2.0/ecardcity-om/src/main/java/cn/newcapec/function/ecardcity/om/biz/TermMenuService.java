/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz;

import java.util.List;
import java.util.Map;

import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.model.TermMainMenu;
import cn.newcapec.function.ecardcity.om.model.TermSubMenu;

/**
 * @author wj
 * @category 终端菜单服务接口
 * @version 1.0
 * @date 2014年4月22日 下午1:10:10
 */
public interface TermMenuService extends BaseService<TermMainMenu> {
    /**
     * 根据map，查询指定的菜单分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回分页列表
     */
    public Page<?> getPageMenu(Map<String, Object> paramMap);
    /**
     * 根据map，查询指定的主菜单分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回分页列表
     */
    public Page<?> getPageMainMenu(Map<String, Object> paramMap);
    /**
     * 根据map，查询指定的子菜单分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回分页列表
     */
    public Page<?> getPageSubMenu(Map<String, Object> paramMap);
    /**
     * 批量删除模板参数
     * @param ids	ID数组
     */
    public void delete(String[] ids);
    /**
     * 根据主菜单名称、终端名称删除菜单
     * @param mainMenu	主菜单名称
     * @param termid	终端ID
     */
    public void deleteByMainMenu(String mainMenu,String termid);    
    /**
     * 根据termid，查询已用的二级菜单权限位置
     * @param termid	 	终端ID
     * @return List 		已用的权限列表位置
     */
    public List<?> getPermLocListByTerm(String termid);
    /**
     * 保存子菜单
     * @param subMenu	 	子菜单
     * @return 
     */
    public void saveOrUpdateSubMenu(TermSubMenu subMenu);
}
