package cn.shishc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:cn.shishc
 * @Date:2020/12/29
 * @Auther:ShiShc
 */

@RestController
@SpringBootApplication
public class MyFirstSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringApplication.class, args);
    }

    @RequestMapping("/")
    String hello() {
        return "hello";
    }
}
