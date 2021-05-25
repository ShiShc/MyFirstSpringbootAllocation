package com.shishc.util;

import com.shishc.entity.Attachment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

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

    private static Attachment fileBox(MultipartFile file, String path, Long uid) throws IOException {
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
        String diskFileName = "0-" + tempstamp + "-" + originalFilename;
        long fileSize = file.getSize();

        file.transferTo(new File(dir, diskFileName));
        attachment.setAttachName(diskFileName);
        attachment.setAttachSize(fileSize);
        attachment.setTimestamp(tempstamp);
        attachment.setAttachSuffix(attachSuffix);
        attachment.setAttachOrigin(0);
        attachment.setAttachLocation(path);
        attachment.setUserId(uid);

        return attachment;
    }


    public static boolean get(HttpServletResponse response, String path) throws Exception{
        File sourceFile = new File(path);
        if(!sourceFile.isFile() || !sourceFile.exists()) {
            throw new RuntimeException("null");
        }
        String filename = path.substring(path.lastIndexOf("-"));
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        try {
            filename = URLEncoder.encode(filename, "UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            fileInputStream = new FileInputStream(sourceFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int read = bufferedInputStream.read(buffer);
            while(read != -1) {
                outputStream.write(buffer, 0, read);
                read = bufferedInputStream.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("wrong");
        } finally {
            outputStream.close();
            bufferedInputStream.close();
            fileInputStream.close();
        }
        return false;
    }
}
