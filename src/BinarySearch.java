import java.util.Arrays;

/**
 * @Describe 二分查找/ 查询 > = num 最左面的位置/ 查询 < = num 最右面的位置
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/21 21:00
 */
public class BinarySearch {
    public static void main(String[] args) {
        // 定义有序数组
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 判断 4 是否存在
//        System.out.println(binarySearch(arr, 111));
        for (int i = 0; i < 100000; i++) {
            int[] ints = generateTestArray(99, 10);
            Arrays.sort(ints);
            int i1 = (int) (Math.random() * (99 + 1));
            if (isaBoolean2(ints, i1)) {
                System.out.println("出错了");
                System.out.println("样本数据");
                System.out.println(Arrays.toString(ints));
                System.out.println("查询值 : " + i1);
                System.out.println(binarySearchLeft(ints, i1) );
                System.out.println( serchLeft(ints, i1));
                return;
            }
        }
    }

    private static boolean isaBoolean1(int[] ints, int i1) {
        return binarySearch(ints, i1) != eq(ints, i1);
    }

    private static boolean isaBoolean2(int[] ints, int i1) {
        return binarySearchLeft(ints, i1) != serchLeft(ints, i1);
    }

    public static boolean eq(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static int serchLeft(int[] arr, int num) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= num){
                result  = i;
            }
        }
        return result;
    }

    public static int[] generateTestArray(int maxValue, int maxLength) {
        int[] arr = new int[10];
        for (int i = 0; i < maxLength; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    private static boolean binarySearch(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            // 中间值
            int center = (l + r) / 2;
            // 如果查询的值等于中间值那就直接返回
            if (num == arr[center]) {
                return true;
            } else if (num < arr[center]) {
                // num < center 证明要找的数可能在左面
                r = center - 1;
            } else {
                // 在右面
                l = center + 1;
            }
        }
        return false;
    }

    /**
     * 查询 > = num 最左面的位置
     * 查询 < = num 最有面的位置
     *
     * @param arr arr
     * @param num N
     * @return 布尔
     */
    private static int binarySearchLeft(int[] arr, int num) {
        int resultIndex = -1;
        if (arr == null || arr.length == 0) {
            return resultIndex;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int center = (l + r) / 2;
            if (arr[center] <= num) {
                // 如果找到了把返回值设置进去继续找
                l = center + 1;
                resultIndex = center;
            } else {
                // 在右面
                r = center - 1;
            }
        }
        return resultIndex;
    }
}
