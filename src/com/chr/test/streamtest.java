package com.chr.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by changhr2013 on 2018/4/3.
 */
public class streamtest {
    public static void main(String[] args) {
        List<Integer> intList=new ArrayList<Integer>();
        for(int i=1;i<5;i++){
            intList.add(i);
        }

        System.out.println(intList.stream().reduce(1,(a,b)->Math.multiplyExact(a,b)));
    }
}
