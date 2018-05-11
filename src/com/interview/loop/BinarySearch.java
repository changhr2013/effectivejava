package com.interview.loop;

/**
 * Created by Tony on 2018/5/10.
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int k){
        int a = 0, b = arr.length;
        while(a < b){
            //int mid=((a/2)+(b/2))+(((a%2)+(b%2))/2);
            int mid = a + (b - a)/2;
            if(k < arr[mid]){
                b = mid;
            }else if(k > arr[mid]){
                a = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArr1=new int[]{1,2,10,15,26,37,58,100};
        int[] testArr2=new int[]{};
        int[] testArr3=new int[]{12};
        int[] testArr4=new int[]{13};

        BinarySearch binarySearch=new BinarySearch();
        System.out.println(binarySearch.binarySearch(testArr1,15));
        System.out.println(binarySearch.binarySearch(testArr2,15));
        System.out.println(binarySearch.binarySearch(testArr3,13));
        System.out.println(binarySearch.binarySearch(testArr4,13));


    }
}
