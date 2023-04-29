package com.example.springboot_swagger.controller;

import com.example.springboot_swagger.model.bo.UserDetailBO;
import com.example.springboot_swagger.model.entity.User;
import com.example.springboot_swagger.model.vo.DeleteUserVO;
import com.example.springboot_swagger.model.vo.UpdateUserVO;
import com.example.springboot_swagger.response.BaseResponse;
import com.example.springboot_swagger.response.RespGenerator;
import com.example.springboot_swagger.service.IUserService;
import com.example.springboot_swagger.utils.TokenUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(tags = "用户接口")
@RestController
@RequestMapping("userController")
public class UserController {

    @Autowired
    IUserService userService;

    @ApiOperation(value = "修改用户信息")
    @PostMapping("/updateUserMessage")
    public BaseResponse<Integer> updateUserMessage(@RequestBody UpdateUserVO updateUserVO) {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "获取用户列表信息")
    @PostMapping("/getUserList")
    public BaseResponse<List<UserDetailBO>> getUserList() {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "删除用户信息")
    @PostMapping("/deleteUser")
    public BaseResponse<Integer> deleteUser(@RequestBody DeleteUserVO deleteUserVO) {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "登录")
    @GetMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "String"),
            @ApiImplicitParam(name = "passWord", value = "密码", paramType = "String")
    })
    public BaseResponse<HashMap> login(@RequestParam(value = "userName") String userName,
                                       @RequestParam(value = "passWord") String passWord) throws JsonProcessingException {
        return RespGenerator.returnOK(userService.login(userName,passWord));
    }
}
