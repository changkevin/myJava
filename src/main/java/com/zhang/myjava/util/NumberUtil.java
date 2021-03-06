package com.zhang.myjava.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

public class NumberUtil {
	/**
	 * 保留两位小数（四舍五入）
	 * @param num
	 * @return
	 */
	public static Double formatDouble(double num) {
        // 旧方法，已经不再推荐使用
//      BigDecimal bg = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);  
    	
        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(num).setScale(2, RoundingMode.HALF_UP);      
        return bg.doubleValue();
    }
	
	public static Double formatDouble(double num, int precision) {
        // 旧方法，已经不再推荐使用
//      BigDecimal bg = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);  
    	
        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(num).setScale(precision, RoundingMode.HALF_UP);      
        return bg.doubleValue();
    }
	
	public static void main(String[] args) {
		Double a = 3.1415926;
		Double b = 1.0000000000000002;
		Double c = 0.0;
		
		System.out.println(formatDouble(a));
		System.out.println(formatDouble(b));
		
		System.out.println(formatDouble(a, 0));
		System.out.println(formatDouble(b, 0));
		System.out.println(c);
		if(c !=0.0 ) {
			System.out.println("c!=0");
		}
	}
}
