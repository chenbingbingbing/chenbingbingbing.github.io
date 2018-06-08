package com.hotel.defException;

public class MyException extends Exception{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	
	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "MyException [message=" + message + "]";
	}
	
	
}
