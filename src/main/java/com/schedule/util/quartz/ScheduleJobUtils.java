
package com.schedule.util.quartz;

import com.schedule.config.ThreadPoolCache;
import com.schedule.dao.ScheduleJobDO;
import com.schedule.dao.ScheduleJobLogDO;
import com.schedule.mapper.ScheduleJobLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 定时任务工具
 *  该类为执行方法，每次触发定时器时执行的方法
 *
 */
@Slf4j
@Component
public class ScheduleJobUtils extends QuartzJobBean {

	@Autowired
	private ScheduleJobLogMapper scheduleJobLogMapper;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        ScheduleJobDO scheduleJob = (ScheduleJobDO ) context.getMergedJobDataMap()
        		.get("JOB_KEY");

        //获取spring bean
//        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");
		long startTime = System.currentTimeMillis();
        //数据库保存执行记录
        ScheduleJobLogDO jobLog = new ScheduleJobLogDO(scheduleJob,startTime);

        //任务开始时间

		Byte zero = 0;

		Byte one=1;
        try {
            //执行任务
        	log.info("任务准备执行，任务ID：" + scheduleJob.getJobId());
            ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(),
            		scheduleJob.getMethodName(), scheduleJob.getParams());
            Future<?> future = ThreadPoolCache.InitThreadPoolCache.executorService.submit(task);

			future.get();

			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			jobLog.setTimes((int)times);
			//任务状态    0：成功    1：失败
			jobLog.setStatus(zero);

			log.info("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒");
		} catch (Exception e) {
			log.error("任务执行失败，任务ID：" + scheduleJob.getJobId(), e);

			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			jobLog.setTimes((int)times);

			//任务状态    0：成功    1：失败
			jobLog.setStatus(one);
			jobLog.setError(e.toString().substring( 0, 199));
		}finally {
			scheduleJobLogMapper.insert(jobLog);
		}
    }
}
