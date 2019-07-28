package ChildTree;

import sun.management.snmp.util.SnmpTableCache;

/**
 * 描述 0 - 1背包问题
 *一组物品 其重量为 W1 W2 W3....
 *         其价值为 V1 V2 V3....
 * 现在有一个背包，可以容纳c ，如何装入物品使得价值最大
 */
public class Package {
    static int []w={8,7,9,6,11};
    static int []v={10,8,12,13,9};
    static int c=18;
    static int []x=new int[w.length]; //背包中的物品
    static int []bestX=new int[w.length];//物品的最优组
    static int bestV=Integer.MIN_VALUE;//价值的最优
    static int cw=0; //背包的重量
    static int cv=0;  //背包的价值
    static int r=0;//剩余的物品 价值总和
    public static void main(String[] args) {
        int []p =new int[w.length];
        func(0);

    }

    private static void func(int i) {
        if (i==x.length) {
//            for (int j = 0; j < w.length; j++) {
//                p[j]=w[j];
//                if (p[i]==1) {
//                    System.out.print(p[j]);
//                }
//        }
            System.out.println(x[i]);
        }
        else {
            x[i]=1;
            func(i+1);

            x[i]=0;
            func(i+1);
        }
    }
}
