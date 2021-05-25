package icu.shishc;

import io.github.bluemiaomiao.annotation.EnableFastdfsClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @date: 2021-5-25, 10:52
 * @author: ShiShc
 */

@EnableFastdfsClient
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
