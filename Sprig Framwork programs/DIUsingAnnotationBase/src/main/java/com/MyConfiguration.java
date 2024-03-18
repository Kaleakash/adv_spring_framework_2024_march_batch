package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration				// beans.xml 
@ComponentScan(basePackages = "com")  // context tag 
public class MyConfiguration {

}
