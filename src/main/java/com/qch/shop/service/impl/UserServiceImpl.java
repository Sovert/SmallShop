package com.qch.shop.service.impl;

import com.qch.shop.mapper.UserMapper;
import com.qch.shop.model.entity.User;
import com.qch.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service impl
 * @author Qiu Chenhao
 * @date 2019-07-15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
