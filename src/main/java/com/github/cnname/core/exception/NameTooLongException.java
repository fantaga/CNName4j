package com.github.cnname.core.exception;

/**
 * Created by Administrator on 2016/12/2.
 */
public class NameTooLongException extends Exception{
	public NameTooLongException() {
		super();
	}

	public NameTooLongException(String message) {
		super(message);
	}
}
