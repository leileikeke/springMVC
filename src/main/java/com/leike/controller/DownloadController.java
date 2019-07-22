package com.leike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-22 14:39
 */
@Controller
@RequestMapping("/download")
public class DownloadController {

    private static String parentPath = "D:"+ File.separator;

    @RequestMapping("/down")
    @ResponseBody
    public String down(HttpServletResponse response){
//        response.setCharacterEncoding("UTF-8");
        //通过输出流写到客户端 , 浏览器
        // 1 获取我就爱你下载名
        String filename = "夜景.jpg";
        // 2 构建一个文件对象,通过Paths工具类获取一个Path对象
        Path path = Paths.get(parentPath, filename);
        // 3 判断它是否存在
        if (Files.exists(path)){
            //存在则开始下载
            //通过response设定他的响应的类型
            // 4 获取文件的后缀
            String fileSuffix = filename.substring(filename.lastIndexOf(".")+1);
            // 5 设置Header头信息>contenType , 只有指定它才能去下载
            response.setContentType("application/"+fileSuffix);
            // ISO8859-1
            try {
                response.addHeader("Content-Disposition","attachment; filename="+new String(filename.getBytes("UTF-8"),"ISO8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // 6 通过Path写出去 -- end
            try {
                Files.copy(path,response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            return "未找到资源文件";
        }
        return "ok";
    }
}
