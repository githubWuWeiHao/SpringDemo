package com.company.xml;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class EmpDemo {
public static void main(String[] args) throws Exception {
//	1- 获取pull的xml解析器对象 pullParser
    XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
	//2-读取配置文件信息，把信息传递给pullParser解析器
    InputStream in = EmpDemo.class.getClassLoader().getResourceAsStream("emp.xml");
    parser.setInput(in,"utf-8");
	// 3-获取解析器事件类型,生成集合和user对象
    int type = parser.getEventType();
    List<Emp> emps = null;
    Emp emp = null;
    while((type = parser.getEventType())!= XmlPullParser.END_DOCUMENT) {
    	// 4-根据解析器事件类型，产生不同操作，直到文档读取结束
    	switch(type) {
    	case XmlPullParser.START_DOCUMENT:
    		emps = new ArrayList<Emp>();
    		break;
    	case XmlPullParser.START_TAG:
    		String tagname = parser.getName();
    		if("emp".equals(tagname)) {
    			emp = new Emp();
    			String idStr = parser.getAttributeValue(null, "empno");
    			emp.setEmpno(Integer.parseInt(idStr));
    		}
    		if("ename".equals(tagname)) {
    			emp.setEname(parser.nextText());
    		}
    		if("deptno".equals(tagname)) {
    			emp.setDeptno(Integer.valueOf(parser.nextText()));
    		}
    		if("sal".equals(tagname)) {
    			emp.setSal(new BigDecimal(parser.nextText()));
    		}
    		break;
    	case XmlPullParser.END_TAG:
    		if("emp".equals(parser.getName())) {
    			emps.add(emp);
    		}
    	}
    	parser.next();
    }
	// 5-获得封装了user对象的集合对象，进行使用
    for(Emp u:emps) {
    	System.out.println(u);
    }
}
}

