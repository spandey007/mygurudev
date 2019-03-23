package com.sell.snm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SnMDemoApp {

	public static void main(String[] args) {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

Vibrator vib = context.getBean("vibrator",Vibrator.class);

final String[] str = vib.getRandomThoughtService();

System.out.println(str[0]);
System.out.println(str[1]);
System.out.println(str[2]);
System.out.println(vib.getDesc());
System.out.println(vib.getProductCategory());
System.out.println(vib.getProce());
context.close();

	}

}
