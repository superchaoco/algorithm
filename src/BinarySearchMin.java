import java.util.Arrays;

/**
 * @Describe 二分查找局部最小
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/22 9:24
 */
public class BinarySearchMin {
    public static void main(String[] args) {
        int maxCount = 10000000;
        int maxValue = 99;
        int maxLength = 15;
        for (int i = 0; i < maxCount; i++) {
            int[] ints = BinarySearchMin.generateTestArray(maxValue, maxLength);
            int min = BinarySearchMin.searchMin(ints);
            boolean test = BinarySearchMin.test(ints, min);
            if (!test) {
                System.out.println("样本数据");
                System.out.println(Arrays.toString(ints));
                System.out.println("返回数据" + min);
                return;
            }
        }
        System.out.println("一切正常");
    }

    /**
     * 测试
     *
     * @param arr      数组
     * @param minIndex 最小值索引
     * @return boolean
     */
    public static boolean test(int[] arr, int minIndex) {
        // 先定义边界条件
        if (arr == null) {
            return -1 == minIndex;
        }
        int length = arr.length;
        if (length == 1) {
            // 就一个数假定他就是局部最小
            return 0 == minIndex;
        }
        if (arr[0] < arr[1]) {
            // 如果0<1 0就是局部最小
            return 0 == minIndex;
        }
        if (arr[length - 1] < arr[length - 2]) {
            // 如果最后一个数比前一位小那最后一位数就是局部最小
            return length - 1 == minIndex;
        }
        return arr[minIndex] <= arr[minIndex - 1] && arr[minIndex] <= arr[minIndex + 1];

    }

    /**
     * 对数器
     *
     * @param maxValue  最大值
     * @param maxLength 最小值
     * @return int 数组
     */
    public static int[] generateTestArray(int maxValue, int maxLength) {
        int length = (int) (Math.random() * maxLength + 1);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * maxValue + 1);
            while (i != 0 && random == arr[i - 1]) {
                random = (int) (Math.random() * maxValue + 1);
            }
            arr[i] = random;
        }
        return arr;
    }

    /**
     * 查询一个数组的任意一个局部最小值(0坐标 < 右面 0就是局部最小 , length - 1 < length - 2 length - 1 就是局部最小)
     * 中间值是小于左面也小于右面, 数组无序,并且相邻两个数一定不相等
     *
     * @return 局部最小值索引
     */
    public static int searchMin(int[] arr) {
        // 先定义边界条件
        if (arr == null) {
            return -1;
        }
        int length = arr.length;
        if (length == 1) {
            // 就一个数假定他就是局部最小
            return 0;
        }
        if (arr[0] < arr[1]) {
            // 如果0<1 0就是局部最小
            return 0;
        }
        if (arr[length - 1] < arr[length - 2]) {
            // 如果最后一个数比前一位小那最后一位数就是局部最小
            return length - 1;
        }
        // 定义左坐标
        int l = 0;
        // 定义右坐标
        int r = length - 1;
        // 定义中间值
        while (l <= r) {
            int middle = (l + r) / 2;
            if (middle == 0) {
                return middle + 1;
            }
            // 如果中间值小于左面也小于右面那中间值这个索引未位置的数就是局部最小值
            // 中间值一共有几种情况
            // 小于左面   小于右面 -- > =就是自己
            // 小于左面   大于右面 -- > 向右找
            // 大于左面   小于右面 -- > 向左         1  2  3
            // 大于左面   大于右面 -- > 向左/向右     1  2  1 -- > 这个时候左右都应该是都有局部最小值的
            if (arr[middle] < arr[middle - 1] && arr[middle] < arr[middle + 1]) {
                return middle;
            } else if (arr[middle] < arr[middle - 1]) {
                l = middle + 1;
            } else {
                // 走到这一定是大于左面 就向左找
                r = middle - 1;
            }
        }
        return -1;
    }
}
