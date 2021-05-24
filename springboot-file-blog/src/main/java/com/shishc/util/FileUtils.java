package com.shishc.util;

import com.shishc.entity.Attachment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;

/**
 * @date: 2021-5-24, 16:50
 * @author: ShiShc
 */

public class FileUtils {

    public static String ATTACH_PATH = "S:\\MyFirstSpringbootAllocation\\attachments";

    public static Attachment upload(MultipartFile file, Long uid) {

        try {
            Attachment attachment = fileBox(file, ATTACH_PATH, uid);
            if(attachment != null) {
                return attachment;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Attachment fileBox(MultipartFile file, String path, Long uid) {
        String originalFilename = file.getOriginalFilename();
        if(StringUtils.isBlank(originalFilename)) {
            return null;
        }

        Attachment attachment = new Attachment();

        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdir();
        }
        String attachSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        long tempstamp = System.currentTimeMillis();
        // 新名称
        String diskFileName = String.valueOf(tempstamp) + "-" + originalFilename;
        long fileSize = file.getSize();

        attachment.setAttachName(diskFileName);
        attachment.setAttachSize(fileSize);
        attachment.setTimestamp(tempstamp);
        attachment.setAttachSuffix(attachSuffix);
        attachment.setAttachLocation(path);
        attachment.setUserId(uid);

        return attachment;
    }


    public static boolean get(HttpServletResponse response, String path, String filename) {
        return false;
    }
}
