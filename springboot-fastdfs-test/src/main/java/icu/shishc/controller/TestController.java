package icu.shishc.controller;

import icu.shishc.util.FastdfsUtil;
import io.github.bluemiaomiao.service.FastdfsClientService;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @date: 2021-5-25, 11:12
 * @author: ShiShc
 */

@RestController
public class TestController {

    @Autowired
    FastdfsClientService remoteService;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public String[] upload(@RequestParam MultipartFile file) {
        String[] remoteInfo = null;
        try {
            remoteInfo = remoteService.upload("group1", file.getBytes(), "png", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return remoteInfo;
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String download(@RequestParam String group, @RequestParam String fileId) throws FastdfsException, UnsupportedEncodingException, NoSuchAlgorithmException {
//        try {
//            url = remoteService.autoDownloadWithoutToken(group, fileId, UUID.randomUUID().toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return FastdfsUtil.getSourceUrl(group, fileId);
    }

}
