package com.leike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-21 19:55
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static String uploadPath = "D:"+ File.separator;

    //入参就可以代表上传的文件
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile, Model model) {
        /**
         * 1.传到那里去
         * 2. 传什么东西
         * 3. 传的细节
         */
        // 1.不为空才上传
        if (multipartFile!=null && !multipartFile.isEmpty()) {
            //2.获取原始的文件名
            String originalFilename1 = multipartFile.getOriginalFilename();
            //3. 先截取源文件的文件名前缀 , 不带后缀
            String fileNamePrefix = originalFilename1.substring(0, originalFilename1.lastIndexOf("."));
            //4. 加工处理文件名 , 将原文件名+时间戳
            String newfileNamePrefix = fileNamePrefix+new Date().getTime();
            System.out.println(new Date().getTime());
            //5. 得到新文件名
            String newFilename = newfileNamePrefix+originalFilename1.substring(originalFilename1.lastIndexOf('.'));
            //6. 构建文件对象
            File file = new File(uploadPath + newFilename);
            //7.上传
            try {
                multipartFile.transferTo(file);
                model.addAttribute("fileName",newFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "file/uploadSuc";
    }

}
