package com.example.stestweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author qt
 * @Date 2021/3/25
 * @Description
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo(@RequestParam String username){
        return userInfoService.getUserInfoByUsername(username);
    }
}