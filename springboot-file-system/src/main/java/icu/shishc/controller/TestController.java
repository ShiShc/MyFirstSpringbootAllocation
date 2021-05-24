package icu.shishc.controller;

import icu.shishc.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @date: 2021-5-24, 09:58
 * @author: ShiShc
 */

@RestController
public class TestController {

    private final ResourceLoader resourceLoader;

    private final String path = "S:\\MyFirstSpringbootAllocation\\springboot-file-system\\files";

    @Autowired
    public TestController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile file) {
        String msg = "";

        if(FileUtils.upload(file, path, file.getOriginalFilename())) {
            msg = "success";
        } else {
            msg = "failed";
        }

        return msg;
    }


    @GetMapping("/image")
    public void getImage(@RequestParam String imageUrl, HttpServletResponse response) {
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;

        try {
            File file = new File(imageUrl);
            if(!file.exists()) {
                System.out.println("tu pian bu cun zai");
                return;
            }
            fileInputStream = new FileInputStream(imageUrl);
            int i = fileInputStream.available();
            byte[] buffer = new byte[i];
            fileInputStream.read(buffer);
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("utf-8");
            outputStream = response.getOutputStream();
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    @RequestMapping(value = "show", method = RequestMethod.GET)
//    public ResponseEntity show(String filename) {
//        try {
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + "S:/MyFirstSpringbootAllocation/springboot-file-system/files/" + filename));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
