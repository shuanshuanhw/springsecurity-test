package com.example.stestweb.qita;

import com.example.stestweb.qita.StudentJDBCTemplate;
import com.example.stestweb.qita.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class Com {
    @Autowired
    TestBean getTestBean;

    @Autowired
    StudentJDBCTemplate studentJDBCTemplate;

    @GetMapping("/test")
    @ResponseBody
    public String test()
    {

        String s = "";

        String tr;
        return "test";
    }
//    @GetMapping("/login")
//    public String login()
//    {
//        return "login";
//    }
}
