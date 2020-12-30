package cn.shishc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:cn.shishc.controller
 * @Date:2020/12/30, 16:31
 * @Auther:ShiShc
 */


@RestController
@RequestMapping("/root")
public class RootController {
    @RequestMapping("/product")
    public String productInfo() {
        return "RootController -> productInfo";
    }
}
