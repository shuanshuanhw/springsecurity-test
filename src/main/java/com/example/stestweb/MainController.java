package com.example.stestweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @Author qt
 * @Date 2021/3/25
 * @Description 主控制器
 */
@Controller
public class MainController {


    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    @GetMapping("/hello")
    public String printStr(){
        System.out.println("hello success");
        return "Hello success!";
    }

    @GetMapping("/login2")
    public String login2()
    {
        System.out.println("login2");
        return "login2";
    }

    @GetMapping("/login3")
   // @ResponseBody
    public String login3()
    {
        System.out.println(jdbcTemplateObject.queryForList("select * from users"));
        System.out.println(jdbcTemplateObject.queryForList("select * from users"));
        System.out.println(jdbcTemplateObject.queryForList("select * from users"));
        System.out.println(jdbcTemplateObject.queryForList("select * from users"));
        System.out.println(jdbcTemplateObject.queryForList("select * from users"));
        System.out.println(jdbcTemplateObject.queryForList("select * from users"));
        System.out.println(jdbcTemplateObject.queryForList("select * from users"));
        System.out.println(jdbcTemplateObject.queryForList("select * from users"));

        return "login2";
    }

//    @PostMapping(value = "/user/login")
//    @ResponseBody
//    public String successLogin(@RequestBody UserInfo userInfo)
//    {
//        System.out.println(userInfo+"已经登陆");
//        return "成功登陆";
//    }


    @GetMapping("/login")
    @ResponseBody
    public String loginPage(){
        System.out.println("login page");
        return "login";
    }


    @GetMapping("/index")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String index(){
        System.out.println("index page");
        return "index";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    @ResponseBody
    public String printAdmin(){
        System.out.println("hello admin");
        return "admin";
    }

    @GetMapping("/user")
  //  @PreAuthorize("hasAnyRole('ROLE_USER')")
    @RolesAllowed("ROLE_USER")
    public String printUser() {

        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();

            System.out.println(currentUserName);

        }return "user";
    }

    @GetMapping("/denied")
    public String denied()
    {
        return "denied";
    }
    /**
     * 找不到页面
     */
    @GetMapping("/404")
    public String notFoundPage() {
        return "/error/404";
    }
    /**
     * 未授权
     */
    @GetMapping("/403")
    public String accessError() {
        return "/error/403";
    }
    /**
     * 服务器错误
     */
    @GetMapping("/500")
    @ResponseBody
    public String internalError() {
        return "/error/500";
    }

}