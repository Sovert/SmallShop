package com.qch.shop.service.impl;

import com.qch.shop.mapper.LogMapper;
import com.qch.shop.mapper.UserMapper;
import com.qch.shop.model.entity.Log;
import com.qch.shop.model.entity.User;
import com.qch.shop.service.LogService;
import com.qch.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service impl
 * @author Qiu Chenhao
 * @date 2019-07-15
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void add(Log log) {
        logMapper.add(log);
    }
}
