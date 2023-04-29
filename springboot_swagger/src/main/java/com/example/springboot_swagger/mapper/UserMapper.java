package com.example.springboot_swagger.mapper;

import com.example.springboot_swagger.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author arise
 * @since 2023-04-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
