package com.shishc.util;

import com.shishc.entity.Attachment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;
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
        String test = "S:\\MyFirstSpringbootAllocation\\attachments\\0-1621849325261-head.jpg";
        File sourceFile = new File(test);
        if(!sourceFile.isFile() || !sourceFile.exists()) {
            System.out.println("啥也不是");
        }
//        File sourceFile = new File(path);
//        if(!sourceFile.isFile() || !sourceFile.exists()) {
//            throw new RuntimeException("null");
//        }
        String filename = test.substring(test.lastIndexOf("-"));
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        try {
//            filename = URLEncoder.encode(filename, "UTF-8");
//            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            fileInputStream = new FileInputStream(sourceFile);
            outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            //            filename = URLEncoder.encode(filename, "UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/force-download");
//            response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
//            fileInputStream = new FileInputStream(sourceFile);
//            bufferedInputStream = new BufferedInputStream(fileInputStream);
//            outputStream = response.getOutputStream();
//            byte[] buffer = new byte[1024];
//            int read = bufferedInputStream.read(buffer);
//            while(read != -1) {
//                outputStream.write(buffer, 0, read);
//                read = bufferedInputStream.read(buffer);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("wrong");
        } finally {
            System.out.println("....");
            outputStream.close();
//            bufferedInputStream.close();
            fileInputStream.close();
        }
        return false;
    }

    public static ResponseEntity<byte[]> getImg() throws FileNotFoundException {
        String path = "D:\\uploadTest\\1621907917509.jpg";
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytesByStream = getBytesByStream(inputStream);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(bytesByStream, httpHeaders, HttpStatus.OK);
    }

    private static  byte[] getBytesByStream(FileInputStream fileInputStream) {
        byte[] bytes = new byte[1024];
        int b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            while((b = fileInputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, b);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {

        }
        return null;
    }

}
