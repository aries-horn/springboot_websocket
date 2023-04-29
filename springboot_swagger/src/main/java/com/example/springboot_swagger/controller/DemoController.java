package com.example.springboot_swagger.controller;

import com.example.springboot_swagger.response.BaseResponse;
import com.example.springboot_swagger.response.RespGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "demo接口")
@RestController
@RequestMapping("/Demo")
public class DemoController {

    @ApiImplicitParam(name = "id",value = "demo的id",paramType = "String")
    @ApiOperation(value = "getDemo")
    @GetMapping("/getDemo")
    public BaseResponse<Object> Demo(@RequestParam(value = "id") String id){
        System.out.println(id);
        return RespGenerator.returnOK("成功");
    }

}
