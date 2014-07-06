/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.util;

import org.restlet.Finder;
import org.restlet.Restlet;
import org.restlet.Router;
import org.restlet.ext.spring.SpringBeanFinder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * rest路由器
 * @author andy.li
 *
 */
public class NspRouter  extends Router  implements  BeanFactoryPostProcessor {

	/*权限路由*/
	public static final String privilegeRoute = "/privilegeProxyService";
	/*门户路由*/
	public static final String portalRoute = "/portalProxyService";

    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory)
            throws BeansException {
    	/*注入权限信息*/
    	attach(privilegeRoute, (Restlet)factory.getBean("privilegeRoute"));
    	/*注入门户信息*/
    	attach(portalRoute, (Restlet)factory.getBean("portalRoute"));
    }

    
    protected Finder createFinder(BeanFactory beanFactory, String beanName) {
        return new SpringBeanFinder(beanFactory, beanName);
    }

    
}
