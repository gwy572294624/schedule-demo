package com.schedule.dao;

public class ScheduleJobLogDO {
    /**
     *  任务日志id,所属表字段为tb_schedule_job_log.log_id
     */
    private Long logId;

    /**
     *  任务id,所属表字段为tb_schedule_job_log.job_id
     */
    private Long jobId;

    /**
     *  spring bean名称,所属表字段为tb_schedule_job_log.bean_name
     */
    private String beanName;

    /**
     *  方法名,所属表字段为tb_schedule_job_log.method_name
     */
    private String methodName;

    /**
     *  参数,所属表字段为tb_schedule_job_log.params
     */
    private String params;

    /**
     *  任务状态    0：成功    1：失败,所属表字段为tb_schedule_job_log.status
     */
    private Byte status;

    /**
     *  失败信息,所属表字段为tb_schedule_job_log.error
     */
    private String error;

    /**
     *  耗时(单位：毫秒),所属表字段为tb_schedule_job_log.times
     */
    private Integer times;

    /**
     *  创建时间,所属表字段为tb_schedule_job_log.ctime
     */
    private Long ctime;

    /**
     *  ,所属表字段为tb_schedule_job_log.yn
     */
    private String yn;

    /**
     *  修改时间,所属表字段为tb_schedule_job_log.utime
     */
    private Long utime;

    public ScheduleJobLogDO(ScheduleJobDO scheduleJob, Long startTime) {
        this.jobId = scheduleJob.getJobId();
        this.beanName = scheduleJob.getBeanName();
        this.methodName = scheduleJob.getMethodName();
        this.params = scheduleJob.getParams();
        this.ctime = startTime/1000;
        this.utime = startTime/1000;
    }

    public ScheduleJobLogDO() {
    }

    public ScheduleJobLogDO(Long logId, Long jobId, String beanName, String methodName, String params, Byte status, String error, Integer times, Long ctime, String yn, Long utime) {
        this.jobId = jobId;
        this.beanName = beanName;
        this.methodName = methodName;
        this.params = params;
        this.status = status;
        this.error = error;
        this.times = times;
        this.ctime = ctime;
        this.yn = yn;
        this.utime = utime;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName == null ? null : beanName.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error == null ? null : error.trim();
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getYn() {
        return yn;
    }

    public void setYn(String yn) {
        this.yn = yn == null ? null : yn.trim();
    }

    public Long getUtime() {
        return utime;
    }

    public void setUtime(Long utime) {
        this.utime = utime;
    }
}