package com.qch.shop.mapper;

import com.qch.shop.model.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * User Mapper
 *
 * @author Qiu Chenhao
 * @date 2019-07-15
 */
@Component
@Mapper
public interface UserMapper {
    /**
     * add user
     *
     * @param user add user object
     * @return update count
     */
    @Insert("insert into user(username, password) values(#{username}, #{password})")
    int add(User user);

    /**
     * update user
     *
     * @param user update user object
     * @return update count
     */
    @Update("update user set username=#{username}, password=#{password} where id=#{id}")
    int update(User user);

    /**
     * delete user by id
     *
     * @param id delete user's id
     * @return update count
     */
    @Delete("delete from user where id=#{id}")
    int deleteById(String id);

    /**
     * get user by id
     *
     * @param id find user's id
     * @return user's object
     */
    @Select("select * from user where id=#{id}")
    User getUserById(String id);
}
