package cn.shishc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:cn.shishc.controller
 * @Date:2020/12/30, 16:09
 * @Auther:ShiShc
 */

@RestController
public class BasicController {

    @RequestMapping("/hello")
    String home() {
        return "Springboot - SpringSecurity!";
    }
}
