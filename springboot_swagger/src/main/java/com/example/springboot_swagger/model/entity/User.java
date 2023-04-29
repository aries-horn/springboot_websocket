package com.example.springboot_swagger.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class User {

    private String uid;

    private String userName;

    private String password;

}