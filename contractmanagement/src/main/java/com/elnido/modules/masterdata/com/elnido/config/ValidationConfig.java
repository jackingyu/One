package com.elnido.modules.masterdata.com.elnido.config;

import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.xml.validation.Validator;

@Configuration
public class ValidationConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setDefaultEncoding("utf-8");
        source.setCacheMillis(-1);
        source.setBasename("ValidationMessages");
        return source;
    }

//    @Bean
//    public Validator validator() {
//        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
//        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
//        factoryBean.setValidationMessageSource(messageSource());
//        return factoryBean;
//    }
}
