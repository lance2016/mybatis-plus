package com.lance.mybatisplus.bytecode;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @program: mybatisplus  T006MyBeanPostProcessor
 * @description:
 * @author: flchen
 * @create: 2021-07-19 22:55
 **/
@Component
public class T006MyBeanPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("hi");
    }
}
