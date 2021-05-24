package com.shishc.controller;

import com.shishc.entity.Attachment;
import com.shishc.util.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @date: 2021-5-24, 16:47
 * @author: ShiShc
 */

@RestController
public class FileController {
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void upload(@RequestParam MultipartFile file, @RequestParam Long uid) throws Exception{
        Attachment attachment = FileUtils.upload(file, uid);
        System.out.println(attachment);
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public void getAttach(@RequestParam String path, @RequestParam String filename, HttpServletResponse response) {
        FileUtils.get(response, path, filename);
    }

}
