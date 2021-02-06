package com.schedule.mapper;

import com.schedule.dao.ScheduleJobDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleJobMapper {
    int insert(ScheduleJobDO scheduleJobDO);

    int deleteByPK(Long jobId);

    int updateByPK(ScheduleJobDO scheduleJobDO);

    ScheduleJobDO selectByPK(Long jobId);

    long count(ScheduleJobDO scheduleJobDO);

    List<ScheduleJobDO> select(ScheduleJobDO scheduleJobDO);
}