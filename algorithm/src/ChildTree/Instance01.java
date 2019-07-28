package ChildTree;

import java.util.Arrays;

public class Instance01 {
    /**
     * 有一个整数，让你选择其中的一部分数字，让选择的数字和剩下的数字它们的和的
     * 差最小，把选择的数字打印出来
     * 适当的加入剪枝操作 来降低时间复杂度
     * 练习 ：给定一个整数 和 一组数，得到这组数中一部分数等于这个整数
     * @param args
     */
    static int[] arr = {12,5,7,32,21,20,18,14};
    static int[] x = new int[arr.length];//
    static int[] bestx = new int[arr.length];//最优数组
    static int minval = Integer.MAX_VALUE;
    static int sum = 0;
    static int count=0;

    public static void main(String[] args) {
        for (int val : arr) {
            sum += val;//求arr的和
        }
        func(arr, 0, arr.length);

        System.out.println("minval:" + minval);//
//        System.out.println(Arrays.toString(bestx));
        for (int i = 0; i < bestx.length; i++) {
            if(bestx[i] == 1){
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void func(int[] arr, int i, int length) {
        if(i == length){
//            if (count!=length/2){
//                return;
//            }
            int s=0;
            for (int j = 0; j < arr.length; j++) {
                if(x[j] == 1){
                    s += arr[j];
                }
            }

            int r = Math.abs(s - (sum-s));
            if(r < minval){
                minval = r;
                for (int j = 0; j < x.length; j++) {
                    bestx[j] = x[j];
                }
            }
        } else {
            if (count!=length/2){
                //            sum += arr[i];
                count+=1;
                x[i] = 1;
                func(arr, i+1, length);
//            sum -=arr[i];
                count-=1;
                x[i] = 0;
                func(arr, i+1, length);
            }

        }
    }
}
