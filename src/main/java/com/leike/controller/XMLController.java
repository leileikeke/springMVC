package com.leike.controller;

import com.leike.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-21 15:52
 */
@Controller
@RequestMapping("/xml")
public class XMLController {

    //描述生产的类型 , 返回类型的描述 , 返回什么数据
    @RequestMapping(value = "/m1",produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User m1(){
        // 希望springmvc将数据转换为xml形式user
        User user = new User("好","11",null);

        return user;
    }

}
