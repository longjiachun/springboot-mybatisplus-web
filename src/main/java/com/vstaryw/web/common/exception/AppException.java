package com.vstaryw.web.common.exception;


/**
 * 后台接口调用异常类
 * @author vstaryw
 *
 */
public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2671643227097369681L;
	private String errCode;

	public AppException() {}

	public AppException(String errMsg, Throwable cause) {
		super(errMsg,cause);
	}
	
	public AppException(String errCode, String errMsg) {
		super(errMsg);
		this.errCode = errCode;
	}

	public AppException(String errCode, String msg, Throwable cause) {
		super(msg,cause);
		this.errCode = errCode;
	}
	
	public String getErrorCode(){
		return errCode;
	}
	
}
