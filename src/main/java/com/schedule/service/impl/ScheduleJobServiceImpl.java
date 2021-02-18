package com.schedule.service.impl;

import com.alibaba.fastjson.JSON;
import com.schedule.dao.ScheduleJobDO;
import com.schedule.mapper.ScheduleJobMapper;
import com.schedule.service.ScheduleJobService;
import com.schedule.util.quartz.ScheduleUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Date 2021/2/6 上午10:33
 * @Version 1.0
 * @Remarks
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;
    @Autowired
    private Scheduler scheduler;
    @Override
    public List<ScheduleJobDO> getAll(){
        ScheduleJobDO scheduleJobDO = new ScheduleJobDO();
        scheduleJobDO.setYn("y");
        return scheduleJobMapper.select(scheduleJobDO);
    }

    @Override
    public String addJob(ScheduleJobDO scheduleJobDO) {
        scheduleJobMapper.insert(scheduleJobDO);
        ScheduleUtils.createScheduleJob(scheduler,scheduleJobDO);
        return "add执行成功 ！！";
    }

    @Override
    public String updateJob(ScheduleJobDO scheduleJobDO) {
        scheduleJobMapper.updateByPK(scheduleJobDO);
        ScheduleUtils.updateScheduleJob(scheduler,scheduleJobDO);
        return "update执行成功 ！！";
    }

    @Override
    public String deleteJob(Long jobId) {
        scheduleJobMapper.deleteByPK(jobId);
        ScheduleUtils.deleteScheduleJob(scheduler,jobId);
        return "delete执行成功 ！！";
    }
}
