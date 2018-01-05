package com.vstaryw.web.controller;


import com.vstaryw.web.common.result.ErrorCode;
import com.vstaryw.web.common.result.JsonResult;

/**
 * Describe: 基础控制器
 */
public class BaseController {
    /**
     * 渲染失败数据
     *
     * @return result
     */
    protected JsonResult renderError() {
        JsonResult result = new JsonResult(ErrorCode.UNKNOWN_ERROR.getCode(),ErrorCode.UNKNOWN_ERROR.getMsg());
        return result;
    }

    /**
     * 渲染失败数据（非异常情况带消息）
     *
     * @param msg 需要返回的消息
     * @return result
     */
    protected JsonResult renderError(String code,String msg) {
        JsonResult result = new JsonResult(code,msg);
        return result;
    }

    /**
     * 渲染失败数据（非异常情况带消息）
     * @param errorCode 定义的错误码
     * @return
     */
    protected JsonResult renderError(ErrorCode errorCode){
        return renderError(errorCode.getCode(),errorCode.getMsg());
    }

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected JsonResult renderSuccess() {
        JsonResult result = new JsonResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMsg());
        return result;
    }

    /**
     * 渲染成功数据（带数据）
     *
     * @param data 需要返回的对象
     * @return result
     */
    protected JsonResult renderSuccess(Object data) {
        JsonResult result =renderSuccess();
        result.setData(data);
        return result;
    }
}
