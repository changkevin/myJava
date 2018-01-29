package com.zhang.myjava.test;

public class PrintRMB {
	public static void main(String[] args) {
		char number[]={'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
		char unit0[]={' ','拾','佰','仟'};
		char unit1[]={' ','万','亿'};
	  
		double target=1232346.78;
		//这个值单位可以取到千亿。可以测试一下。（注意小数只能有两位，这是根据需求做的）
		String targeto=String.valueOf(target); 
		String result[]=targeto.split("[.]");
		int group=(result[0].length()%4==0)?result[0].length()/4:result[0].length()/4+1;
		StringBuffer sb=new StringBuffer();
		int first=0;
		String str=null;
		for(int i=0;i<group;i++){
		   if(i==0){
		    first=result[i].length()%4;
		    str=result[i].substring(0,first);
		    for(int j=0;j<str.length();j++){
		     int m=Integer.parseInt(String.valueOf(str.charAt(j)));
		     int n=str.length()-j-1;
		     sb.append(number[m]);
		     sb.append(unit0[n]);
		    }
		    sb.append(unit1[group-i-1]);
		   }else{
			    str=result[0].substring(first+i*4-4,first+i*4);
			    for(int j=0;j<str.length();j++){
			     int m=Integer.parseInt(String.valueOf(str.charAt(j)));
			     int n=str.length()-j-1;
			     sb.append(number[m]);
			     sb.append(unit0[n]);
			    }
			    sb.append(unit1[group-i-1]);
		   }
	  }
	  sb.append("元");
	  int m=Integer.parseInt(String.valueOf(str.charAt(0)));
	  sb.append(number[m]);sb.append("角");
	  m=Integer.parseInt(String.valueOf(str.charAt(1)));
	  sb.append(number[m]);sb.append("分");
	  
	  System.out.println(sb.toString());
	 }
}

