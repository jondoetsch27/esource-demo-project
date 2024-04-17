package com.jdd.esource_demo_project;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@TestConfiguration
public class EsourceDemoProjectTestConfiguration {
    private static final int MIN = 0;
    private static final int MAX = 50;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Integer getMin() {
        return MIN;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Integer getMax() {
        return MAX;
    }
}
