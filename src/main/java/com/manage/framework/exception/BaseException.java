package com.manage.framework.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *系统基准异常类 
 * @author Administrator
 *
 */
public class BaseException extends Exception {
	
	private static final long serialVersionUID = 5376845987777073175L;
	
	/**
	 * 错误代码
	 */
	private Enum<ErrorCode> errorCode = null;
	
	/** 嵌入的异常实例 */
	protected Throwable cause;
	
	public Enum<ErrorCode> getErrorCode() {
		return this.errorCode;
	}
	
	public void setErrorCode(Enum<ErrorCode> errorCode) {
		this.errorCode = errorCode;
	}
	
	/** 构造函数 */
	public BaseException() {
		super("* Error occured in BaseException *");
	}
	
	/** 构造函数 */
	public BaseException(String message) {
		super(message);
	}
	
	/** 构造函数 */
	public BaseException(Throwable cause) {
		super(cause);
	}
	
	/** 构造函数 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
		this.cause = cause;
	}
	
	/** 构造函数 */
	public BaseException(Enum<ErrorCode> errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	/* (non-Javadoc)
	* @see java.lang.Throwable#getMessage()
	*/
	public Throwable initCause(Throwable cause) {
		this.cause = cause;
		return cause;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		String msg = super.getMessage();
		Throwable parent = this;
		Throwable child;
		/**  Look for nested exceptions */
		while((child = getNestedException(parent)) != null) {
			/**  get the child's message */
			String msg2 = child.getMessage();
			if(msg2 != null) {
				if(msg != null) {
					msg = ": " + msg2;
				}else{
					msg = msg2;
				}
			}
			if(child instanceof BaseException) {
				break;
			}
			parent = child;
		}
		return msg;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#printStackTrace()
	 */
	public void printStackTrace() {
		super.printStackTrace();
		Throwable parent = this;
		Throwable child;
		while((child = getNestedException(parent)) != null) {
			if(child != null) {
				System.err.print("Caused by: ");
				child.printStackTrace();
				if(child instanceof BaseException) {
					break;
				}
				parent = child;
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
		Throwable parent = this;
		Throwable child;
		while((child = getNestedException(parent)) != null) {
			if(child != null) {
				s.print("Caused by: ");
				child.printStackTrace(s);
				if(child instanceof BaseException) {
					break;
				}
				parent = child;
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace(PrintWriter w) {
		super.printStackTrace(w);
		Throwable parent = this;
		Throwable child;
		/** Print the stack trace for each nested exception */
		while((child = getNestedException(parent)) != null) {
			if(child != null) {
				w.print("Caused by: ");
				child.printStackTrace(w);
				if(child instanceof BaseException) {
					break;
				}
				parent = child;
			}
		}
	}
	
	/**
	 * @see java.lang.Throwable#getCause()
	 */
	public Throwable getCause() {
		return cause;
	}
	
	/**
	 * 获取被嵌入的异常
	 * @param e 包裹异常
	 * @return 嵌入异常
	 */
	public Throwable getNestedException(Throwable e) {
		if(e != null) {
			return e.getCause();
		}
		return null;
	}
	
}
