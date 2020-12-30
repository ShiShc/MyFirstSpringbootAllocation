package cn.shishc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @PackageName:cn.shishc
 * @Date:2020/12/29
 * @Auther:ShiShc
 */

@SpringBootApplication
@MapperScan("cn.shishc.dao")
public class SpringMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisApplication.class, args);
    }
}
