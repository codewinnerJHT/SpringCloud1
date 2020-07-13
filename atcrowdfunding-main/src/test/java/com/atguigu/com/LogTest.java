package com.atguigu.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

public class LogTest {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LogTest.class);
		logger.debug("debug..."); //用于调试程序
		logger.info("info...");//用于请求处理提示消息
		logger.warn("warn...");//用于警告处理提示消息
		logger.error("error...");//用于异常处理提示消息
		logger.error("==>>"+logger.getClass());
		//class ch.qos.logback.classic.Logger
	}
}
