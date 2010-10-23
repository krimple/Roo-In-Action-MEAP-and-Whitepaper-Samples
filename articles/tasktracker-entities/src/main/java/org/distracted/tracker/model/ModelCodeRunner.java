package org.distracted.tracker.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ModelCodeRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
		ModelCode code = ctx.getBean("ModelCode", ModelCode.class);
		code.test();
	}
}
