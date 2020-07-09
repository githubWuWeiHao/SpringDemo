package com.company.reflevtion;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import com.company.xml.Emp;

public class RefDemo {
public static void main(String[] args) throws Exception {
	String className = "com.company.xml.Emp";
	Class clazz = Class.forName(className);
	Field field = clazz.getDeclaredField("ename");
	String setterName = "set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
	String getterName = "get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
	String ename = "SCOTT";
	Method setter = clazz.getDeclaredMethod(setterName, field.getType());
	Object obj = clazz.newInstance();
	setter.invoke(obj, ename);
	Method getter = clazz.getDeclaredMethod(getterName);
	System.out.println(getter.invoke(obj));
	Field sal = clazz.getDeclaredField("sal");
	sal.setAccessible(true);
	sal.set(obj, new BigDecimal("6.8"));
	Emp emp = (Emp)obj;
	System.out.println(emp.getSal());
}
}
