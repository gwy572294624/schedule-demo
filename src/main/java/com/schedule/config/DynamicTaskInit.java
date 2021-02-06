package com.schedule.config;

import com.schedule.dao.ScheduleJobDO;
import com.schedule.service.ScheduleJobService;
import com.schedule.util.quartz.ScheduleUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Author
 * @Date 2021/2/5
 * @Version 1.0
 * @Remarks 项目启动将动态定时器加载到系统中
 */
@Component
public class DynamicTaskInit implements ApplicationRunner {

    @Autowired
    @Qualifier("scheduleJobServiceImpl")
    private ScheduleJobService scheduleJobService;
    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("加载动态定时器");
        List<ScheduleJobDO> scheduleJobDOList = scheduleJobService.getAll();
        if (!ObjectUtils.isEmpty(scheduleJobDOList)){
            for (ScheduleJobDO thisJob:scheduleJobDOList) {
                ScheduleUtils.createScheduleJob(scheduler, thisJob);
            }
        }

    }
}
