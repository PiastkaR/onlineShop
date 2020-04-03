package com.queue.your.patient.infrastructure.quartz;


import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.quartz.Calendar;

import java.util.*;

import static java.util.Optional.ofNullable;

@Configuration
@EnableConfigurationProperties(QuartzProperties.class)
@EnableScheduling
public class SchedulingConfiguration {

    private final QuartzProperties quartzProperties;
    private final Optional<JobDetail[]> jobDetail;
    private final Optional<Map<String, Calendar>> calendars;
    private final Optional<Trigger[]> triggers;

    public SchedulingConfiguration(QuartzProperties quartzProperties, ObjectProvider<JobDetail[]> jobDetails,
                                   ObjectProvider<Map<String, Calendar>> calendars, ObjectProvider<Trigger[]> triggers) {
        this.quartzProperties = quartzProperties;
        this.jobDetail = ofNullable(jobDetails.getIfAvailable()).filter(j -> j.length > 0);
        this.calendars = ofNullable(calendars.getIfAvailable()).filter(c -> !c.isEmpty());
        this.triggers = ofNullable(triggers.getIfAvailable()).filter(triggers1 -> triggers1.length > 0);
    }

    @Bean
    AutowireCapableBeanJobFactory autowireCapableBeanJobFactory() {
        return new AutowireCapableBeanJobFactory();
    }

    @Bean
    public SchedulerFactoryBean quartzScheduler() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(autowireCapableBeanJobFactory());
        schedulerFactoryBean.setQuartzProperties(asProperties(quartzProperties.getProperties()));
        jobDetail.ifPresent(schedulerFactoryBean::setJobDetails);
        calendars.ifPresent(schedulerFactoryBean::setCalendars);
        triggers.ifPresent(schedulerFactoryBean::setTriggers);
        return schedulerFactoryBean;
    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }
}
