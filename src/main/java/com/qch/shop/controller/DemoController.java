package com.qch.shop.controller;

import com.qch.shop.model.entity.User;
import com.qch.shop.service.UserService;
import com.qch.shop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qiu Chenhao
 * @date 2019-07-15
 */
@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public User getUserById(String id) {
        return userService.getUserById(id);
    }
}
