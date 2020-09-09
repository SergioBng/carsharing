package com.trutsin.config;

import com.trutsin.dal.config.HibernateConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.trutsin.service")
@EnableTransactionManagement
@Import(value = {HibernateConfig.class})
public class RootConfig {

}
