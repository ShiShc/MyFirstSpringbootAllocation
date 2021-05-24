package icu.shishc.controller;

import icu.shishc.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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


    @RequestMapping(value = "show", method = RequestMethod.GET)
    public ResponseEntity show(String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + "S:/MyFirstSpringbootAllocation/springboot-file-system/files/" + filename));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
