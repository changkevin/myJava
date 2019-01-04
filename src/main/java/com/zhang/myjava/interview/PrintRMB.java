package com.zhang.myjava.interview;

public class PrintRMB {
    private static final String[] CN_NUM ={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private static final String[] CN_UNIT ={"分","角","元","拾","佰","仟","万","拾","佰","仟","亿",
            "拾","佰","仟","兆","拾","佰","仟"};
    private static final String CN_FULL = "整";
    private static final String CN_ZERO = "零元" + CN_FULL;


    /**
     * 小数位的情况：00，01，10，11
     * 主要是特别处理小数位和连续为零的情况
     * 最大能表示九拾兆元, 1兆=1万亿
     * 注意long的最大值为: 9223372036854775807 即2的64次方 -1
     * 问题，达到百兆的时候小数位就会不准
     *
     */
    public static String print(double money) {
        int index = 0;
        boolean getZero = false;
        StringBuilder sb = new StringBuilder();
        long  number = (long)(money * 100);  //默认保留两位小数，乘以100后变为整数
        if(number==0) {
            return CN_ZERO;
        }

        System.out.println("number:" + number);
        int smallNum = (int)(number % 100);  //取小数点后两位
        System.out.println("smallNum:" + smallNum);


        if(smallNum==0) { //特殊处理小数位都是零的情况
            sb =sb.insert(0, CN_FULL);
            number = number / 100;
            index+=2;
            getZero = true;
        } else if(smallNum >0 && smallNum%10==0) {
            number = number / 10;
            index+=1;
            getZero = true;
        }

        while(number > 0) {
            int num = (int)(number % 10);
            if(num == 0) { //三种情况：1.插入零，2.插入元，3.插入万，亿，兆等单位
                if(!getZero) {
                    sb = sb.insert(0, CN_NUM[0]);  //如果是第一个零，则插入零
                }
                if(index == 2) {
                    sb =sb.insert(0,CN_UNIT[index]); //无论是否是零，单位元都应该被插入
                } else if((index-2)%4 == 0 && (number % 1000 > 0)) { //解决万，亿等位都是零的情况
                    System.out.println("---number:" + number);
                    System.out.println("---index:" + index);
                    sb =sb.insert(0,CN_UNIT[index]); //插入万，亿，兆等单位
                }
                getZero = true;
            } else  {
                sb =sb.insert(0,CN_UNIT[index]);
                sb = sb.insert(0,CN_NUM[num]);
                getZero = false;
            }

            number = number / 10;
            System.out.println("number:" + number);
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        double money = 10000000000001.01;
        String rmb = PrintRMB.print(money);
        System.out.println("rmb:" + rmb);
    }
}
