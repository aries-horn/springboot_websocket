package com.example.springboot_swagger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot_swagger.model.bo.UserDetailBO;
import com.example.springboot_swagger.model.bo.UserLoginBO;
import com.example.springboot_swagger.model.entity.User;
import com.example.springboot_swagger.mapper.UserMapper;
import com.example.springboot_swagger.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot_swagger.utils.TokenUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author arise
 * @since 2023-04-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserLoginBO login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        queryWrapper.eq("password", password);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
        if (user == null) {
            return null;
        }else {
            UserDetailBO userDetailBO = new UserDetailBO();
            BeanUtils.copyProperties(user, userDetailBO);
            UserLoginBO userLoginBO = new UserLoginBO();
            userLoginBO.setUserDetailBO(userDetailBO);
            // 包装token
            String token = TokenUtils.sign(user);
            userLoginBO.setToken(token);
            return userLoginBO;
        }
    }
}
