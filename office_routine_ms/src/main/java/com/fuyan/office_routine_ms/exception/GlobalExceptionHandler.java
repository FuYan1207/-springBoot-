package com.fuyan.office_routine_ms.exception;


import com.fuyan.office_routine_ms.pojo.Result;
import com.mysql.cj.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();//打印异常
        return Result.error(!StringUtils.isNullOrEmpty(e.getMessage()) ? e.getMessage():"操作失败");
    }
}
