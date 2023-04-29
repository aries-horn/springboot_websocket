package com.example.springboot_swagger.service;

import com.example.springboot_swagger.model.bo.UserLoginBO;
import com.example.springboot_swagger.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author arise
 * @since 2023-04-29
 */
public interface IUserService extends IService<User> {

    UserLoginBO login(String username, String password);

}
