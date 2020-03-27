package com.exmaple.Demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SpringTask {
    private static final Logger log = LoggerFactory.getLogger(SpringTask.class);

    @Scheduled(cron = "1/5 * * * * *")
    public void task1(){
        log.info("springtask 定时任务！");
    }

    @Scheduled(initialDelay = 1000,fixedRate = 1*1000)
    public void task2(){
        log.info("springtask 定时任务！");
    }

}
