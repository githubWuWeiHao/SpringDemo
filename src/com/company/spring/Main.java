package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	Person zhao = (Person) ctx.getBean("zhao");
	System.out.println(zhao.getPhone().getBrand());
	System.out.println(zhao.getPhone().getPrice());
	System.out.println(zhao.getPname());
	
	DecimalUtil decimalUtil = (DecimalUtil) ctx.getBean("decimalUtil");
	System.out.println(decimalUtil.add("1.2", "3.4"));
}
}
