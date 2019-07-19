package com.leike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-12 16:37
 */
@Controller
@RequestMapping("/web")
public class WebElementController {

    /**
     * 正版request
     */
    @RequestMapping("/request")
    public String request(HttpServletRequest request,Model model){

        String boy = request.getParameter("boy");
        model.addAttribute("boy",boy);
        return "/redircet";
    }

    /**
     *  Spring自己'抄'的request
     */
    @RequestMapping("/request2")
    public String request2(WebRequest request, Model model){

        String boy = request.getParameter("boy");
        model.addAttribute("boy",boy);
        return "/forword";
    }

    @RequestMapping("/request3")
    public String request3(HttpSession session,Model model){
        //会话级别的重定向不会丢失
        session.setAttribute("session","神庙逃亡,你妹呀,好想睡觉");
        //model会丢失
        model.addAttribute("model","你妹呀");
        return "redirect:/jsp/redirect.jsp";
    }

    @RequestMapping(path = {"/m1","/m2"},method = RequestMethod.POST)
    public String m1(Model model){
        System.out.println("m1 m2............");
        model.addAttribute("name","这是m1 m2 的请求");
        return "forword";
    }

    //GetMapping和RequestMapping里面的method指定为get是一样的
    @GetMapping(path = {"/m3"})
    public String m3(Model model){
        System.out.println("m3............");
        model.addAttribute("name", "这是 m3 的请求");
        return "forword";
    }
    @DeleteMapping(path = {"/m4"})
    public String m4(Model model){
        System.out.println("delete 进来了");
        model.addAttribute("name","这是 m4 的请求");
        return "/forword";

    }

}
