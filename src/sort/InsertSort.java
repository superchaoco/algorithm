package sort;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/18 21:59
 */
public class InsertSort {

    /**
     * 过程概述 :
     * <p>
     * 0-1索引之间保证有序
     * 0-2索引之间保证有序
     * 0-3索引之间保证有序
     * ...
     * 0-n索引之间保证有序
     * 一旦发现新加入的索引比左面的小,就交换位置在往左遍历,直到自己是第一位或者比前一位大
     * <p>
     * <p>
     * 生活举例 : 像斗地主一样,小牌放左面,大牌放后面,新抓牌依次像左面比较
     *
     * @param arr 数组
     */
    private static void insertSort(int[] arr) {
        // check boundary
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    private static void printArr(int[] arr) {
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // definition array
        int[] arr = {3, 5, 6, 2, 4, 5, 6, 7, 8, 9, 1, 1, 1,};
        // before sorting print
        printArr(arr);
        // sorting
        insertSort(arr);
        // after soring print
        printArr(arr);
    }
}
