package com.example.stestweb;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

// 新建DatabaseUserDetailsService继承UserDetailsService，并重写loadUserByUsername方法
// 在用户登陆时，spring会调用这个方法去获得user的信息（密码等），以对比页面传过来的用户名和密码是否正确。

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /**
         * 1/通过userName 获取到userInfo信息
         * 2/通过User（UserDetails）返回details。
         */
        //通过userName获取用户信息
        UserInfo userInfo = userInfoService.getUserInfoByUsername(userName);
        if(userInfo == null) {
            throw new UsernameNotFoundException("not found");
        }

        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> authorities1 = userInfoService.getAuthorities(userName);
        for(String auth:authorities1)
        {
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头

        User userDetails = new User(userInfo.getUserName(),passwordEncoder.encode(userInfo.getPassword()),authorities);
        return userDetails;
    }
}