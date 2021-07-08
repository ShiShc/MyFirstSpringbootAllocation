package icu.shishc.exception.dto;

import icu.shishc.exception.constant.ResponseEnums;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Response implements Serializable {

    private String msg;
    private int code;
    private String time;
    private Object data;

    private Response() {

    }

    private Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.time = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }

    private Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.time = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        this.data = data;
    }

    public static Response success() {
        return new Response(ResponseEnums.SUCCESS.code, ResponseEnums.SUCCESS.msg);
    }

    public static Response success(Object data) {
        return new Response(ResponseEnums.SUCCESS.code, ResponseEnums.SUCCESS.msg, data);
    }

    public static Response success(Object data, String msg) {
        return new Response(ResponseEnums.SUCCESS.code, msg, data);
    }

    public static Response fail() {
        return new Response(ResponseEnums.EXCEPTION.code, ResponseEnums.EXCEPTION.msg);
    }

    public static Response fail(ResponseEnums responseEnums) {
        return new Response(responseEnums.code, responseEnums.msg);
    }

    public static Response fail(ResponseEnums responseEnums, Object data) {
        return new Response(responseEnums.code, responseEnums.msg, data);
    }

    public static Response fail(int code, String msg) {
        return new Response(code, msg);
    }

    public static Response fail(int code, String msg, Object data) {
        return new Response(code, msg, data);
    }


}
