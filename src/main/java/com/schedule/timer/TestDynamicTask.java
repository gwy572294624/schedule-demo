package com.schedule.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @Author
 * @Date 2021/2/5 下午3:31
 * @Version 1.0
 * @Remarks 动态定时器执行的类
 */
@Slf4j
@Component
public class TestDynamicTask {


    //测试方法
    public void test(String params){
        log.info(params);
        System.out.println(System.currentTimeMillis());
    }


    //测试方法2
    public void test2(String params){
        log.info(params);
        System.out.println(System.currentTimeMillis());
    }

}
