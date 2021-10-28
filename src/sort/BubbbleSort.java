package sort;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/18 21:59
 */
public class BubbbleSort {

    public static void bubbbleSort(int[] arr) {
        // check boundary
        if (arr == null || arr.length < 2) {
            return;
        }
        boolean flag;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
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
        bubbbleSort(arr);
        // after soring print
        printArr(arr);
    }
}
