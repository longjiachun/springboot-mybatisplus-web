package com.vstaryw.web.controller;




import com.vstaryw.web.common.exception.AppException;
import com.vstaryw.web.common.result.ErrorCode;
import com.vstaryw.web.common.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class ExceptionHandlerController {

    Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Exception ex){
        JsonResult jsonResult;
        if(ex instanceof AppException){
            jsonResult = new JsonResult(((AppException) ex).getErrorCode(),ex.getMessage());
        }else{
            log.error("the request error :"+ex.getMessage(),ex);
            jsonResult = new JsonResult(ErrorCode.UNKNOWN_ERROR.getCode(),ErrorCode.UNKNOWN_ERROR.getMsg());
        }
        return jsonResult;
    }
}
