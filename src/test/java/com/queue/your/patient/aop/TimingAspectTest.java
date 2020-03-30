package com.queue.your.patient.aop;

import com.queue.your.patient.IntegrationTest;

import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class TimingAspectTest extends IntegrationTest {
    @Autowired
    private TimingAspect aspect;

    @Test
    public void contextLoad() {
        final Aspect annotation = AnnotationUtils.findAnnotation(TimingAspect.class, Aspect.class);

        assertThat(annotation).isNotNull();
    }
}
