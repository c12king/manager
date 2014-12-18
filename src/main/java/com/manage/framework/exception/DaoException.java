package com.manage.framework.exception;

/**
 * 系统的数据访问对象异常类
 * @author Administrator
 *
 */
public class DaoException extends BaseException {

	public DaoException() {
		
	}
	
	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(Throwable cause) {
		super(cause);
	}
	
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DaoException(Enum<ErrorCode> errorCode, String message, Throwable cause) {
		super(message, cause);
		this.setErrorCode(errorCode);
	}
	
}
