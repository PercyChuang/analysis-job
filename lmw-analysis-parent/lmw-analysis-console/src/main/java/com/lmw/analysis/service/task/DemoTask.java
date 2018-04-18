package com.lmw.analysis.service.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmw.analysis.model.ScheduleJobDO;
import com.lmw.analysis.service.impl.DemoTaskService;
import com.modest.core.util.ApplicationContextHolder;

public class DemoTask extends BaseJob{

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void handle(ScheduleJobDO scheduleJob) throws Exception {
		logger.info("=======================任务 start =======================");
    	try {
    		DemoTaskService service  = ApplicationContextHolder.get().getBean(DemoTaskService.class);
    		service.run();
    	} catch(Exception e) {
    		logger.error("异常", e);
    	}
        logger.info("======================= end =======================");
	}
	
}
