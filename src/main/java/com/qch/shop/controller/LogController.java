package com.qch.shop.controller;

import com.qch.shop.annotation.LogAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * log controller
 * @author Qiu Chenhao
 * @date 2019-07-15
 */
@RestController
public class LogController {
    @LogAnnotation("执行方法一")
    @GetMapping("/one")
    public void methodOne(String name) { }

    @LogAnnotation("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    @LogAnnotation("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) { }
}
