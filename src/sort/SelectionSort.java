package sort;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/18 21:59
 */
public class SelectionSort {

    private static void selectionSort(int[] arr) {
        // check boundary
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < length; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            // change of position
            if (i != minValueIndex) {
                swap(arr, i, minValueIndex);
            }
        }
    }

    private static void swap(int[] arr, int i, int minValueIndex) {
        int tem = arr[i];
        arr[i] = arr[minValueIndex];
        arr[minValueIndex] = tem;
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
        selectionSort(arr);
        // after soring print
        printArr(arr);
    }
}
