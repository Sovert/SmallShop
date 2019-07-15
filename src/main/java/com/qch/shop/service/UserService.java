package com.qch.shop.service;

import com.qch.shop.model.entity.User;
/**
 * User Service
 *
 * @author Qiu Chenhao
 * @date 2019-07-15
 */
public interface UserService {
    /**
     * add user
     *
     * @param user add user object
     * @return update count
     */
    int add(User user);

    /**
     * update user
     *
     * @param user update user object
     * @return update count
     */
    int update(User user);

    /**
     * delete user by id
     *
     * @param id delete user's id
     * @return update count
     */
    int deleteById(String id);

    /**
     * get user by id
     *
     * @param id find user's id
     * @return user's object
     */
    User getUserById(String id);
}
