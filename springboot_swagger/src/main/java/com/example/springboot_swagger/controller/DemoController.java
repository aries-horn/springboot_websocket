package com.example.springboot_swagger.controller;

import com.example.springboot_swagger.config.WebSocket;
import com.example.springboot_swagger.response.BaseResponse;
import com.example.springboot_swagger.response.RespGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "demo接口")
@RestController
@RequestMapping("/Demo")
public class DemoController {

    @Resource
    private WebSocket webSocket;

    @ApiImplicitParam(name = "id",value = "demo的id",paramType = "String")
    @ApiOperation(value = "getDemo")
    @GetMapping("/getDemo")
    public BaseResponse<Object> Demo(@RequestParam(value = "id") String id){
        System.out.println(id);
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "进度条")
    @PostMapping("/jinDuTiao")
    // @Scheduled(cron = "0/30 * * * * ? ") //@Scheduled注解是Spring框架提供的一个注解，它用于标记一个方法是一个定时任务方法。
    // cron表达式是一个字符串，由6个或7个字段组成，用于配置定时任务的执行时间。这些字段分别表示：秒、分、时、日、月、周、年（可选）
    public void jinDuTiao() throws InterruptedException {
        System.out.println(1);
        String msg = "";
        int a = 0;
        for (int i = 0; i <= 100;i++ ) {
            msg = String.valueOf(a);
            Thread.sleep(100);
            webSocket.sendMessage(msg);
            a+=1;
        }
    }
}
