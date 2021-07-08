package icu.shishc.exception.service;

import icu.shishc.exception.constant.ResponseEnums;
import icu.shishc.exception.exception.CustomException;
import org.springframework.stereotype.Service;

/**
 * @author: ShiShc
 * @date: 2021/7/8
 * @Desc:
 */
@Service
public class TestService {

    public void get1() throws Exception {
        int i = 1 / 0;
    }

    public void get2() throws Exception {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new CustomException(ResponseEnums.PASSWORD_WRONG.code, "Print error", "Exception");
        }
    }

    public void get3(int x, int y) throws Exception {
        System.out.println(x + y);
    }
}
