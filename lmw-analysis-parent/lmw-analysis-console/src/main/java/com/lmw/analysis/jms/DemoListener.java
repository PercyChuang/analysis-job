package com.lmw.analysis.jms;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.modest.jms.activemq.listener.BaseMessageListener;

public class DemoListener extends BaseMessageListener{
	
	private Logger logger = LoggerFactory.getLogger(DemoListener.class);

	@Override
	public void doExecute(String message) throws Exception {
		logger.info("收到消息"+message);
	}

	@Override
	public void doExecute(Message message) throws Exception {
		
	}

}
