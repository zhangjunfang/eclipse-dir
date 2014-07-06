package com.iisquare.smh.frame.springmvc;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

public class FrameAnnotationBeanNameGenerator extends
		AnnotationBeanNameGenerator {

	@Override
	protected String buildDefaultBeanName(BeanDefinition definition,
			BeanDefinitionRegistry registry) {
		return definition.getBeanClassName();
	}

}
