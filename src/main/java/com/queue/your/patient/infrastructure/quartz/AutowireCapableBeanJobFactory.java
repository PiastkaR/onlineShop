package com.queue.your.patient.infrastructure.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class AutowireCapableBeanJobFactory  extends SpringBeanJobFactory implements ApplicationContextAware {

    private AutowireCapableBeanFactory beanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        this.beanFactory.autowireBean(jobInstance);
        this.beanFactory.initializeBean(jobInstance, null);
        return jobInstance;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        beanFactory = applicationContext.getAutowireCapableBeanFactory();
    }
}
