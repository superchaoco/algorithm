package random;

import sort.BubbbleSort;

import java.util.Arrays;

public class Logarithm {
    public static void main(String[] args) {
        int maxLength = 10;
        int maxValue = 99;
//        测试100000次
        for (int i = 0; i < 100000; i++) {
            int[] logarithm = Logarithm.logarithm(maxLength, maxValue);
            BubbbleSort.bubbbleSort(logarithm);
            boolean store = Logarithm.isStore(logarithm);
            if(!store){
                System.out.println("出错了");
                System.out.println(Arrays.toString(logarithm));
                return;
            }
        }
    }

    public static boolean isStore(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if(i == length - 1){
                return true;
            }
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }


    public static int[] logarithm(int maxLength, int maxValue) {
        int length = (int) (Math.random() * maxLength + 1);
        int[] testArray = new int[length];
        for (int i = 0; i < length; i++) {
            testArray[i] = (int) (Math.random() * maxValue + 1);
        }
        return testArray;
    }

}
