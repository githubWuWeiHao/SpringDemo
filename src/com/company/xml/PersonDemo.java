package com.company.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class PersonDemo {
public static void main(String[] args) throws Exception  {
		//	1- 获取pull的xml解析器对象 pullParser
	    XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
		//2-读取配置文件信息，把信息传递给pullParser解析器
	    InputStream in = PersonDemo.class.getClassLoader().getResourceAsStream("user.xml");
	    parser.setInput(in, "utf-8");
		// 3-获取解析器事件类型,生成集合和user对象
	    int type = parser.getEventType();
	    List<User> users = null;
	    User user = null;
	    while((type = parser.getEventType())!= XmlPullParser.END_DOCUMENT) {
	    	// 4-根据解析器事件类型，产生不同操作，直到文档读取结束
	    	switch(type) {
	    	case XmlPullParser.START_DOCUMENT:
	    		users = new ArrayList<User>();
	    		break;
	    	case XmlPullParser.START_TAG:
	    		String tagname = parser.getName();
	    		if("user".equals(tagname)) {
	    			user = new User();
	    			String idStr = parser.getAttributeValue(null, "id");
	    			user.setId(Integer.parseInt(idStr));
	    		}
	    		if("username".equals(tagname)) {
	    			user.setUsername(parser.nextText());
	    		}
	    		if("password".equals(tagname)) {
	    			user.setPassword(parser.nextText());
	    		}
	    		break;
	    	case XmlPullParser.END_TAG:
	    		if("user".equals(parser.getName())) {
	    			users.add(user);
	    		}
	    	}
	    	parser.next();
	    }
		// 5-获得封装了user对象的集合对象，进行使用
	    for(User u:users) {
	    	System.out.println(u);
	    }
}
}
