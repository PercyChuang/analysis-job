package com.lmw.analysis.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("demoTaskService")
public class DemoTaskService {

	private Logger logger = LoggerFactory.getLogger(DemoTaskService.class);
	
	public void run() {
		logger.info("定时任务在跑啦....");
	}
}
