package com.cy.util;

import com.cy.controller.AlarmController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 心跳更新。启动时执行一次，之后每隔2秒执行一次
 * @Scheduled(fixedRate = 1000*2)
 */

@Component
public class AlamDemo  {
    private String num;

    HttpServletRequest req;

    @Autowired AlarmController alarmController;

    private int i=0;
        @Scheduled(cron="0/30 * * * * ? ") //间隔5秒执行
        public void test(){
            System.out.println("定时任务开始啦，哈哈哈"+i++);
            alarmController.alarmNumAllDrugsDrugs(req,num);
            System.out.println("<<<---------结束执行HR数据同步任务--------->>>");
        }

}
