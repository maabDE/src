package AlgorithmicProgramming;
/*
* 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
* 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/
public class Test1 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 4}, {5, 6, 8}};
        int target = 3;
        System.out.println(find(arr, target));
    }

    private static boolean find(int[][] arr, int target) {
        if (arr == null) {
            return false;
        }
        int row = 0;
        int column = arr[row].length - 1;
        while (row < arr.length && column >= 0) {
            if (target == arr[row][column]) {
                return true;
            }
            if (target < arr[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}