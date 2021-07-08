package icu.shishc.exception.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: ShiShc
 * @date: 2021/7/8
 * @Desc:
 */
@Data
public class CustomException extends Exception implements Serializable {
    private static final long serialVersionID = 1L;

    private int code;

    private String log;

    /**
     * CustomException Constructor
     * @param code Exception Status code
     * @param log Exception log
     * @param msg Exception msg
     */
    public CustomException(int code, String log, String msg) {
        super(msg);
        this.code = code;
        this.log = log;
    }
}
