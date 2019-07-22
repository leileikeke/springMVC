package com.leike.controller;

import com.leike.pojo.Use;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-22 20:08
 */
@Controller
@RequestMapping("/use")
public class UseConterller {

    @RequestMapping("/login")
    public String login(Use use, HttpSession session){
        System.out.println("login...");
        //数据库检查....
        System.out.println("cfyhbjncxdfcghjb"+use);
        //将用户信息存储到会话当中
        session.setAttribute("SESSION_USER",use);
        return "use";
    }
    @RequestMapping("/delete")
    public String delete(){
        System.out.println("delete...");
        return "use";
    }


}
