package ArrayTree;

/**全排列
 * 八皇后问题
 */
public class ArrayTree {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        func(arr,0,arr.length);
    }

    private static void func(int[] arr, int i, int length) {
        if (i==arr.length){
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }else {
            for (int j = i; j < arr.length; j++) {
                swap(arr,i,j);
                func(arr,i+1,arr.length);
                swap(arr,i,j);
            }

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
