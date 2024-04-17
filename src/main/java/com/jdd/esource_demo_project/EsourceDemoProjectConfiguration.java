package com.jdd.esource_demo_project;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EsourceDemoProjectConfiguration {
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
