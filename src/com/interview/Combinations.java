package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by changhr2013 on 2018/5/5.
 */
public class Combinations {

    public void toCombinations(List<Integer> selectedList,List<Integer> data,int n){

        if(n==0){
            for (Integer i :
                    selectedList) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();

            return;
        }

        if(data.isEmpty()){
            return;
        }

        selectedList.add(data.get(0));
        toCombinations(selectedList,data.subList(1,data.size()),n-1);

        selectedList.remove(selectedList.size()-1);
        toCombinations(selectedList,data.subList(1,data.size()),n);
    }

    public static void main(String[] args) {

        Combinations combinations = new Combinations();

        combinations.toCombinations(new ArrayList<>(), Arrays.asList(1,2,3,4,5),2);

    }
}
