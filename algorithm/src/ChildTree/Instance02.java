package ChildTree;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 练习 ：给定一个整数 和 一组数，得到这组数中一部分数等于这个整数
 * arr={2,4,5,8,10}  num=14;
 * 头疼的写出来但是还是不懂啊 
 */
public class Instance02 {
    static int[]arr={2,4,5,8,10};
    static int[]brr=new int[arr.length];//存放的数组
    static int num=14;
    public static void main(String[] args) {
    func(arr,0,arr.length,num);
    }

    private static void func(int[] arr, int i, int length, int num) {
        if (i==arr.length){
            int sum=0;
            for (int j = 0; j < arr.length; j++) {
                if (brr[j]==1){
//                    System.out.print(arr[j]+" ");
                    sum+=arr[j];
                }
            }
            if (sum==num){
                System.out.println();
                System.out.println(Arrays.toString(brr));
            } else return;
        }
        else {
            brr[i]=1;
            func(arr,i+1,length,num);
            brr[i]=0;
            func(arr,i+1,length,num);
        }
    }

}
