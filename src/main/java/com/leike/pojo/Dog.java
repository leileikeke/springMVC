package com.leike.pojo;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-18 20:52
 */
public class Dog {

    private String name;

    private String password;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Dog(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Dog() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
