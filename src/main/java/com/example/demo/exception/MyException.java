package com.example.demo.exception;

public class MyException extends RuntimeException {
	
	public String str;
	/*public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}*/
	public MyException(String str)
	{
		super(str);
	}
	
}
