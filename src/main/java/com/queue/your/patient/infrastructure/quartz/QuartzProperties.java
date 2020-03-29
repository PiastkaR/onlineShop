package com.queue.your.patient.infrastructure.quartz;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties("spring.quart")
public class QuartzProperties {
    /*
    Additional quart props
     */

    private final Map<String, String> properties = new HashMap<>();

    public Map<String, String> getProperties() {return this.properties;}
}
