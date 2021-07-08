package icu.shishc.exception.exception;

import icu.shishc.exception.constant.ResponseEnums;
import icu.shishc.exception.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author: ShiShc
 * @date: 2021/7/8
 * @Desc:
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        if(e instanceof CustomException) {
            CustomException exception = (CustomException) e;
            log.info("CustomException => msg: " + exception.getMessage() + ", log: " + exception.getLog(), exception);
            return Response.fail(exception.getCode(), exception.getMessage(), null);
        } else if(e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            log.error("MethodArgumentNotValidException => msg: " + Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
            return Response.fail(ResponseEnums.WRONG_PARAM.code,
                                ResponseEnums.WRONG_PARAM.msg + "," +
                                        exception.getBindingResult().getFieldError().getDefaultMessage());
        } else {
            log.error("SystemException => msg: " + e.getMessage(), e);
            return Response.fail(ResponseEnums.EXCEPTION.code, ResponseEnums.EXCEPTION.msg, null);
        }
    }
}
