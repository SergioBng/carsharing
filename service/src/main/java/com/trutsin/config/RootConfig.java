package com.trutsin.config;

import com.trutsin.dal.config.DaoConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.trutsin.service")
@EnableTransactionManagement
@Import(value = {DaoConfig.class})
public class RootConfig {

}
