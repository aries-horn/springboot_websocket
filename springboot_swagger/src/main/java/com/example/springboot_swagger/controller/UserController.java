package com.example.springboot_swagger.controller;

import com.example.springboot_swagger.model.bo.UserDetailBO;
import com.example.springboot_swagger.model.vo.DeleteUserVO;
import com.example.springboot_swagger.model.vo.UpdateUserVO;
import com.example.springboot_swagger.response.BaseResponse;
import com.example.springboot_swagger.response.RespGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户接口")
@RestController
@RequestMapping("userController")
public class UserController {

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

}
