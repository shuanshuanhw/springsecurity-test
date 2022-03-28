package com.example.stestweb.qita;

import org.springframework.beans.factory.annotation.Required;

public class TestBean {
    private String usrName;
    private String password;

    public TestBean(String usrName, String password) {
        this.usrName = usrName;
        this.password = password;
        System.out.println("调用 了");
    }


    public String getUsrName() {
        return usrName;
    }


    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "usrName='" + usrName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private void init() {
        System.out.println("bean启动了");
    }
}
