package com.schedule.dao;

public class ScheduleJobDO {
    /**
     *  任务id,所属表字段为tb_schedule_job.job_id
     */
    private Long jobId;

    /**
     *  spring bean名称,所属表字段为tb_schedule_job.bean_name
     */
    private String beanName;

    /**
     *  方法名,所属表字段为tb_schedule_job.method_name
     */
    private String methodName;

    /**
     *  参数,所属表字段为tb_schedule_job.params
     */
    private String params;

    /**
     *  cron表达式,所属表字段为tb_schedule_job.cron_expression
     */
    private String cronExpression;

    /**
     *  ,所属表字段为tb_schedule_job.yn
     */
    private String yn;

    /**
     *  备注,所属表字段为tb_schedule_job.remark
     */
    private String remark;

    /**
     *  创建时间,所属表字段为tb_schedule_job.ctime
     */
    private Long ctime;

    /**
     *  修改时间,所属表字段为tb_schedule_job.utime
     */
    private Long utime;




    public enum BeanName{
        TEST_DYNAMIC_TASK(1,"testDynamicTask"),
        ;
        private int index;
        private String value;
        BeanName(int index, String value) {
            this.index = index;
            this.value = value;
        }
        public int getIndex() {
            return index;
        }
        public String getValue() {
            return value;
        }
    }


    public ScheduleJobDO(String methodName, String params, String cronExpression) {
        Long thisTime = System.currentTimeMillis()/1000;
        this.beanName = BeanName.TEST_DYNAMIC_TASK.getValue();
        this.methodName = methodName;
        this.params = params;
        this.cronExpression = cronExpression;
        this.remark = "remark";
        this.ctime = thisTime;
        this.utime = thisTime;
    }

    public ScheduleJobDO( String beanName, String methodName, String params, String cronExpression, String remark, Long ctime, Long utime) {
        this.beanName = beanName;
        this.methodName = methodName;
        this.params = params;
        this.cronExpression = cronExpression;
        this.remark = remark;
        this.ctime = ctime;
        this.utime = utime;
    }

    public ScheduleJobDO() {
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

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    public String getYn() {
        return yn;
    }

    public void setYn(String yn) {
        this.yn = yn == null ? null : yn.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getUtime() {
        return utime;
    }

    public void setUtime(Long utime) {
        this.utime = utime;
    }
}