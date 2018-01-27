package com.zhang.myjava.test;

public class StringAllConbinations {
	public static void permutateSequence(char[] strArrs,int i){
		System.out.println("---ps---");
        char temp;
        if(strArrs==null||i>strArrs.length||i<0){
            return;
        }
        else if(i==strArrs.length){
           System.out.println(strArrs);
       }
       else{
           for(int j=i;j<strArrs.length;j++){
        	   System.out.println("i:"+i+",j:"+j);
               temp = strArrs[j];//
               strArrs[j] = strArrs[i];
               strArrs[i] = temp;
               permutateSequence(strArrs, i+1);
               temp = strArrs[j];//
               strArrs[j] = strArrs[i];
               strArrs[i] = temp;
           }
       }
   }
   public static void main(String[] args) {
       String str = "12345";
       char strArrs[] = str.toCharArray();
       permutateSequence(strArrs, 0);
   }
}
