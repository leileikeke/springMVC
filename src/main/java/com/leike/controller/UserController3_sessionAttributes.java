package com.leike.controller;

import com.leike.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-18 20:27
 */
@Controller
@RequestMapping("/user3")
@SessionAttributes("user")
public class UserController3_sessionAttributes {

    @ModelAttribute("user")
    public void init(Model model){
        System.out.println("进入init...");
        User u = new User();
        u.setName("王菲");
        model.addAttribute("user",u);
    }
    @RequestMapping("/login")
    public String login(@ModelAttribute User user){
        System.out.println(user);
        return "redirect:/jsp/user.jsp";
    }
}
