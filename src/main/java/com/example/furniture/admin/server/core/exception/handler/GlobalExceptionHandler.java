package com.example.furniture.admin.server.core.exception.handler;

import com.example.furniture.admin.server.common.exception.ServiceException;
import com.example.furniture.admin.server.common.web.JsonResult;
import com.example.furniture.admin.server.common.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.StringJoiner;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className GlobalExceptionHandler
 * @date 2023/06/15 11:41
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
        log.info("开始创建全局异常处理器: GlobalExceptionHandler");
    }
    
    @ExceptionHandler(ServiceException.class)
    public JsonResult handleServiceException(ServiceException e) {
        log.debug("全局异常处理器开始处理ServiceException");
        return JsonResult.fail(e);
    }
    
    @ExceptionHandler(BindException.class)
    public JsonResult handleBindException(BindException e) {
        log.info("全局异常处理器开始处理BindException");

        FieldError fieldError = e.getFieldError();
        assert fieldError != null;
        StringJoiner stringJoiner = new StringJoiner("", "请求新增标签类别失败，", "!");
        stringJoiner.add(fieldError.getDefaultMessage());
        String message = stringJoiner.toString();
        log.warn(message);
        return JsonResult.fail(ServiceCode.ERROR_BAD_REQUEST, message);

    }
    
    @ExceptionHandler(Throwable.class)
    public JsonResult handleThrowable(Throwable e) {
        log.debug("全局异常处理器开始处理Throwable");
        log.debug("异常跟踪信息如下: ", e);
        
        String message = "服务器忙，请稍后再试!";
        return JsonResult.fail(ServiceCode.ERROR_UNKNOWN, message);
    }
}
