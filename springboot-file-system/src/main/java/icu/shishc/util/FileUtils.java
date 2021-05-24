package icu.shishc.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @date: 2021-5-24, 10:04
 * @author: ShiShc
 */

public class FileUtils {
    public static boolean upload(MultipartFile file, String path, String fileName) {
        String realPath = path + "/" + fileName;
        File dest = new File(realPath);
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
