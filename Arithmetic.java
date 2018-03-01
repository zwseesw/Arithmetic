package com.bob.arclayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anan on 2018/3/1.
 * <p>
 *
 */

public class Arithmetic {

    private static int n = 100;


    public static void main(String[] a) {

        initData(n);


    }

    private static void initData(int n){
        List<Integer> data=new ArrayList<>();
        for (int i = 0 ; i < n ;i++) {
            data.add(i);
        }
        calculateLastOne(data);
    }

    /**
     * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
     *
     * 每数到3一次长度减少1
     */
    private static int m=0; //用于标记第一个位置的值 0 1 2
    private static int calculateLastOne(List<Integer> oriData) {
        List<Integer> resList = new ArrayList<>(); // 用来装本轮数完剩下的集合
        if (oriData.size() == 1) {
            resList.add(oriData.get(0));
            System.out.print("res:" + oriData.get(0)); //下标
        }  else {
            for (int i = 0; i < oriData.size(); i++) {
                if ((i + m + 1) % 3 != 0) {
                    resList.add(oriData.get(i));
                }
            }
            int k = (m+oriData.size()%3);
            m = k<3?k:k-3;//下一轮开始的位置 0  1  2
            calculateLastOne(resList);
        }
        return resList.get(0);
    }
}
