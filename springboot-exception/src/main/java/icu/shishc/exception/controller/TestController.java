package icu.shishc.exception.controller;

import icu.shishc.exception.dto.Response;
import icu.shishc.exception.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShiShc
 * @date: 2021/7/8
 * @Desc:
 */

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/get1")
    public Response get1() throws Exception {
        testService.get1();
        return Response.success();
    }


    @GetMapping("/get2")
    public Response get2() throws Exception {
        testService.get2();
        return Response.success();
    }

    @GetMapping("/get3")
    public Response get3(
            @RequestParam("x") int x,
            @RequestParam("y") int y
    ) throws Exception {
        testService.get3(x, y);
        return Response.success();
    }

}
