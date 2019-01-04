package com.zhang.myjava.java.exception;

public class ExceptionTest {
	public  static void main(String[] args) {
		try {
	        int i = 9/0;
	    }catch(ArithmeticException e) {
	    	System.out.println("检查异常...");
	        e.printStackTrace();
	    }
	    System.out.println("还在执行...");
	    
	    boolean flag = true;
	    try{
	    	if(flag) throw new RuntimeException("run wrong");
	    	 
	    	System.out.println("after throw");   
	    }catch(RuntimeException e) {
	    	System.out.println("运行异常...");
	    	System.out.println(e.getMessage());
	    }
	    System.out.println("继续执行...");
	}
}
