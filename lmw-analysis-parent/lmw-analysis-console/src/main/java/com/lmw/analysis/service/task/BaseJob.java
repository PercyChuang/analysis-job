/*
 * Copyright (c) 2015 xiaoniu, Inc. All rights reserved.
 *
 * @authorRalap https://github.com/springlin2012
 *
 */
package com.lmw.analysis.service.task;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.lmw.analysis.common.util.DateUtils;
import com.lmw.analysis.model.ScheduleJobDO;

/**
 * 功能描述: 定时任务基类
 * <p/>
 * 创建人:Ralap
 * <p/>
 * 创建时间: 2016/01/06.
 * <p/>
 * Copyright (c) 深圳利民网金融信息服务有限公司-版权所有
 */
public abstract class BaseJob implements Job {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("${busy.count}")
	private String busyCount;
	
	private static Map<String, Integer> keyCache = new Hashtable<String, Integer>();
	private static Map<String, Integer> busyKeyCache = new Hashtable<String, Integer>();
    
    /**
     * 任务处理流程
     * @param scheduleJob
     * @throws Exception
     */
    protected abstract void handle(ScheduleJobDO scheduleJob) throws Exception;
    
	public void before(ScheduleJobDO scheduleJob) {
		logger.info("========== Begin Task info.[jobName:{}, date:{}] ==============", scheduleJob.getJobName(),
				DateUtils.format(new Date()));
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
		ScheduleJobDO scheduleJob = (ScheduleJobDO) mergedJobDataMap.get(ScheduleJobDO.JOB_PARAM_KEY);
		logger.info("keyCache values:{}", keyCache.toString());
			try {
				if(isConcurrentExecute(context)){
					this.before(scheduleJob);
					this.handle(scheduleJob);
					this.after(scheduleJob);
				}else{
					this.busy(scheduleJob);
				}
			} catch (Exception e) {
				this.error(scheduleJob, e);
			}finally {
				reStoreCache(scheduleJob);
			}
		} 
	
	/**
	 * 重置cache
	 * @param scheduleJob
	 */
	public void reStoreCache(ScheduleJobDO scheduleJob){
		//并发任务删除
		if(getKeyCache(scheduleJob.getJobClass()) <0){
			keyCache.put(scheduleJob.getJobClass(),0);
		}
		//busy超过5次则清除
		if(getKeyCache(scheduleJob.getJobClass()) >= 1 && getBusyKeyCache(scheduleJob.getJobClass()) >=Integer.parseInt(busyCount == null ? "10":busyCount)){
			keyCache.remove(scheduleJob.getJobClass());
		}
	}
	
	public void busy(ScheduleJobDO scheduleJob) {
		busyKeyCache.put(scheduleJob.getJobClass(), getBusyKeyCache(scheduleJob.getJobClass())+1);
		logger.info("========== busy Task.[jobName:{}, date:{}] ==============", scheduleJob.getJobName(),
				DateUtils.format(new Date()));
	}

	public void after(ScheduleJobDO scheduleJob) {
		keyCache.put(scheduleJob.getJobClass(), getKeyCache(scheduleJob.getJobClass()) -1);
		logger.info("========== End Task.[jobName:{}, date:{}] ==============", scheduleJob.getJobName(),
				DateUtils.format(new Date()));
	}

	public void error(ScheduleJobDO scheduleJob, Exception e) {
		keyCache.put(scheduleJob.getJobClass(), getKeyCache(scheduleJob.getJobClass()) -1);
		logger.error("[jobName:{}]", scheduleJob.getJobName());
		logger.error(e.getMessage(), e);
	}

    
	/**
	 * 定时任务并发执行判断(相同的任务不允许并发执行)
	 * 
	 * @param context
	 * @return true : 并发执行
	 * @throws SchedulerException
	 */
	protected boolean isConcurrentExecute(JobExecutionContext context) throws SchedulerException {
		String currentJobName = context.getJobInstance().getClass().getName();
		if (getKeyCache(currentJobName) >= 1) {
			return false;
		}
		List<JobExecutionContext> jobExecutionContexts = context.getScheduler().getCurrentlyExecutingJobs();
		for (JobExecutionContext jobExecutionContext : jobExecutionContexts) {
			String jobName = jobExecutionContext.getJobInstance().getClass().getName();
			if (currentJobName.equals(jobName)) {
				keyCache.put(currentJobName, getKeyCache(currentJobName) +1);
			}
		}
		return true;
	}
	
	private int getKeyCache(String jobName){
		return keyCache.get(jobName) == null ? 0 : keyCache.get(jobName);
	}
	
	private int getBusyKeyCache(String jobName){
		return busyKeyCache.get(jobName) == null ? 0 : busyKeyCache.get(jobName);
	}

}
