package com.zhang.myjava.test;

import java.util.ArrayList;  
import java.util.List;  
/**
 * 
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串:
 * abc、acb、bac、bca、cab和cba。
 *
 */
  
public class CharacterRank {  
    public static void main(String[] args) {  
        List<Integer> s = new ArrayList<Integer>();//数组列表方便数组大小变动。  
        List<Integer> sr = new ArrayList<Integer>();  
        for (int i = 1; i < 4; i++) {  
            s.add(i);  
        }  
        CharacterRank.rank(s, sr);  
    }  
    public static void rank(List<Integer> s,List<Integer> sr){  
        if(s.size()==1){//递归结束条件  
            sr.add(s.get(0));  
            System.out.println(sr.toString());  
            sr.remove(sr.size()-1);  
        }else{  
            for(int i = 0 ; i < s.size(); i++){  
                sr.add(s.get(i));  
                List<Integer> tmp = new ArrayList<Integer>();//tmp是整个输入序列，依次从其中剔除元素，形成新的列表  
                for(Integer it:s)  
                    tmp.add(it);  
                tmp.remove(i);  
                rank(tmp, sr);//递归  
                sr.remove(sr.size()-1);//递归结束，把添加进入的序列元素剔除，换for循环中其他元素  
            }  
        }  
    }  
}  
