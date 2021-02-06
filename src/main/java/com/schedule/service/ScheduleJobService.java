package com.schedule.service;

import com.schedule.dao.ScheduleJobDO;

import java.util.List;

/**
 * @Author
 * @Date 2021/2/6 上午10:33
 * @Version 1.0
 * @Remarks
 */
public interface ScheduleJobService {

    List<ScheduleJobDO> getAll();

    String addJob(ScheduleJobDO scheduleJobDO);

    String updateJob(ScheduleJobDO scheduleJobDO);

    String deleteJob(Long jobId);
}
