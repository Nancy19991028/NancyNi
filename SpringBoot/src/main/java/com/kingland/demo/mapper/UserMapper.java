package com.kingland.demo.mapper;

import com.kingland.demo.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 *
 *
 * @version 1.0.0
 *
 * @description
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * Query user information by user name
     *
     * The user name
     * The user object
     */
    @Select("select * from user_info where username = #{username};")
    UserInfo queryUserByName(String username);
}

