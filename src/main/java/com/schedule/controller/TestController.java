package com.schedule.controller;

import com.alibaba.fastjson.JSON;
import com.schedule.dao.ScheduleJobDO;
import com.schedule.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2021/2/6 上午10:24
 * @Version 1.0
 * @Remarks
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    @Qualifier("scheduleJobServiceImpl")
    private ScheduleJobService scheduleJobService;

    @RequestMapping("/getall")
    public String getAll(String name){
        return JSON.toJSONString(scheduleJobService.getAll());
    }


    @RequestMapping("/add")
    public String addJob(String methodName,String params,String cronExpression){
        ScheduleJobDO scheduleJobDO=new ScheduleJobDO(methodName,params,cronExpression);
        return scheduleJobService.addJob(scheduleJobDO);
    }

    @RequestMapping("/update")
    public String updateJob(Long jobId,String methodName,String params,String cronExpression){
        ScheduleJobDO scheduleJobDO=new ScheduleJobDO(methodName,params,cronExpression);
        scheduleJobDO.setJobId(jobId);
        return scheduleJobService.updateJob(scheduleJobDO);
    }

    @RequestMapping("/delete")
    public String deleteJob(Long jobId){
        return scheduleJobService.deleteJob(jobId);
    }
}
