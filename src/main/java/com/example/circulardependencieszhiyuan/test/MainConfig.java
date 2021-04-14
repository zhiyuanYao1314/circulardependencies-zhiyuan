package com.example.circulardependencieszhiyuan.test;

import org.springframework.context.annotation.*;

/**
 * Created by xsls on 2019/5/29.
 */
@Configuration
@ComponentScan(basePackages = {"com.example.circulardependencieszhiyuan.test"})
//@ImportResource(value = {"classpath:beans/beans.xml"})
@EnableAspectJAutoProxy
public class MainConfig {



}
