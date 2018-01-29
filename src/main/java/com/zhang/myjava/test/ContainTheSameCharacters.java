package com.zhang.myjava.test;

/**
 * 判断两个字符串是否由相同的字符组成
 * byte [-128, 127]
 * ASCII码表0~127
 * ASCII扩展字符——（为了适应更多字符）128~255
 */
public class ContainTheSameCharacters {
	public static boolean isSame(String str1, String str2) {
		byte[] b1 = str1.getBytes();
		byte[] b2 = str2.getBytes();
		int[] count = new int[256];
		
		if(b1.length != b2.length) return false;
		
		for(int i=0; i<b1.length; i++) {
			//System.out.println(b1[i]);
			count[b1[i]]++;
		}
				
		for(int i=0; i<b2.length; i++) {
			count[b2[i]]--;
		}
		
		for(int i=0; i<256; i++) {
			if(count[i] != 0) return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		String str1="aaaddff";
		String str2="ddaaffa";
		if(ContainTheSameCharacters.isSame(str1, str2)) {
			System.out.println("contain same");
		} else {
			System.out.println("contain not same");
		}
	}
}

