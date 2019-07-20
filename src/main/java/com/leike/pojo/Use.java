package com.leike.pojo;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-20 18:36
 */
public class Use {
    private String name;
    private String pwd;

    @Override
    public String toString() {
        return "Use{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public Use() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Use(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}
