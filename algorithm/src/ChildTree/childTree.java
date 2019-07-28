package ChildTree;

/**
 * 子集树
 */
public class childTree {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int[] brr=new int [arr.length];
        func(arr,0,arr.length,brr);
    }

    private static void func(int[] arr, int i, int length,int[] brr) {
        if (i==arr.length){
//            System.out.println("aa");
            for (int j = 0; j < arr.length; j++) {
                if (brr[j]==1){
                    System.out.print(arr[j]+" ");
                }
//                if (brr[j]==0){
//                    System.out.print(arr[j]+" ");
//                }
            }
            System.out.println();
        }
        else {
            //选择的数组部分
            brr[i]=1;
            func(arr,i+1,arr.length,brr);//访问的左孩子

            //不选择的数组部分
            brr[i]=0;
            func(arr,i+1,arr.length,brr);//访问的右孩子
        }
    }
}
