package com.leike.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-11 15:03
 */

//实现一个Controller接口的方式
public class HelloContreler implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("girl","菲菲");
        modelAndView.setViewName("girl");

        return modelAndView;
    }
}
