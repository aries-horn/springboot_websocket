package com.example.springboot_swagger.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户登录类")
public class UserLoginBO {

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户token")
    private String token;

    public void setUserDetailBO(UserDetailBO userDetailBO){
        this.userName = userDetailBO.getUserName();
        this.password = userDetailBO.getPassword();
    }

    public void setToken(String token){
        this.token = token;
    }
}
