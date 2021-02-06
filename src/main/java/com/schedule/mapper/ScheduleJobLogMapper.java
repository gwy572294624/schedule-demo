package com.schedule.mapper;


import com.schedule.dao.ScheduleJobLogDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleJobLogMapper {
    int insert(ScheduleJobLogDO scheduleJobLogDO);

    int deleteByPK(Long logId);

    int updateByPK(ScheduleJobLogDO scheduleJobLogDO);

    ScheduleJobLogDO selectByPK(Long logId);

    long count(ScheduleJobLogDO scheduleJobLogDO);

    List<ScheduleJobLogDO> select(ScheduleJobLogDO scheduleJobLogDO);
}