package com.zhang.myjava.test;


/**
 * 
 * 将字符串中的单词反转
 * are you ok -> ok you are
 */
public class ReverseWord {
	private void reverse(char[] array, int begin, int end) {
		int mid = (end - begin)/2;
		for(int i=0; i<=mid; i++) {
			char tmp = array[begin+i];
			array[begin+i] = array[end-i];
			array[end-i] = tmp;
		}
	}
	
	public String reverse(String str) {
		int N = str.length();
		char[] array = str.toCharArray();
		//第一次反转
		reverse(array, 0, N-1);
		
		//第二轮反转
		int begin = 0;
		for(int i=0; i<N; i++) {
			if(array[i] == ' ') {
				reverse(array, begin, i-1);
				begin = i+1;
			}			
		}
		
		reverse(array, begin, N-1); //不要忘了交换最后一个单词
		
		return new String(array);
	}
	
	public static void main(String[] args) {
		String str = "it was the best of times";		
		System.out.println(new ReverseWord().reverse(str));
	}

}

