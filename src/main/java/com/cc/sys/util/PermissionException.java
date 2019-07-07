package com.cc.sys.util;

/**
 * @author Cc
 * @data 2019/6/22 14:43
 */
public class PermissionException extends RuntimeException {


	public PermissionException() {
		super();
	}

	public PermissionException(String s) {
		super(s);
	}

	public PermissionException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public PermissionException(Throwable throwable) {
		super(throwable);
	}

	protected PermissionException(String s, Throwable throwable, boolean b, boolean b1) {
		super(s, throwable, b, b1);
	}
}
