package com.vstaryw.web.common.result;

public enum ErrorCode {

    SUCCESS("0","请求成功"),

    UNKNOWN_ERROR("1","未知错误"),

    INVALID_ILLEGAL_REQUEST("100","非法请求"),

    INVALID_PARAM("101","请求参数无效"),

    INCORRECT_SIGNATURE("102","无效签名"),

    INVALID_USER_ID("103","无效的user id"),

    INVALID_ACCESS_TOKEN("104","无效的access token"),

    ACCESS_TOKEN_EXPIRED("105","access token过期"),

    INVALID_VERIFY_CODE("106","验证码错误"),


    USER_NOT_EXIST("201","不存在的用户"),

    USER_INFO_NOT_COMPLETE("202","用户资料未完善"),

    USER_NOT_AUTH("203","对不起，您还没有认证"),

    SPECIFIED_OBJECT_CANNOT_BE_FOUND("204","指定的对象不存在"),

    INVALID_OBJECT_EXIST("205","已重复存在"),

    INVALID_RESUBMIT("300","重复提交"),

    INVOKE_SERVICE_ERROR("400","调用服务出错");

    private String code;

    private String msg;


    private ErrorCode(String code, String msg){
        this.code= code;
        this.msg = msg;
    }

    public static String getMsg(String code){
        for(ErrorCode errorCode : ErrorCode.values()){
            if(errorCode.getCode().equals(code)){
                return errorCode.getMsg();
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
