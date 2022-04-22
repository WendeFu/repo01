package com.lagou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @RequestMapping("/fileUpload")
    public String fileUpload(String username, MultipartFile filePic) throws IOException {
        System.out.println(username);
        String filename = filePic.getOriginalFilename();
        filePic.transferTo(new File("/Users/fuwende/Pictures/upload/" + filename));
        return "success";
    }

    @RequestMapping("/fileUpload2")
    public String fileUpload2(String username, MultipartFile[] filePic) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : filePic) {
            String filename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("/Users/fuwende/Pictures/upload/" + filename));
        }
        return "success";
    }

}
