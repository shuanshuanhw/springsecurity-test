package com.example.stestweb;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserInfoService {

    @Resource
    JdbcTemplate jdbcTemplate;
    public UserInfo getUserInfoByUsername(String userName)
    {
        RowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);
        UserInfo userInfo = jdbcTemplate.queryForObject("select username,password from users where username=?", rowMapper,userName);
        return userInfo;
    }
    public List<String> getAuthorities(String userName) {
    //    RowMapper<Authorities> rowMapper = new BeanPropertyRowMapper<>(Authorities.class);
        List<String> authoritys = jdbcTemplate.queryForList("select authority from authorities where username=?", String.class, userName);
        return authoritys;
    }
}
