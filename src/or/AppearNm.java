package or;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 一个数组中出现一种数M次,一种数K次,K < M,求: K
 */
public class AppearNm {

    public static int find(int[] arr, int m, int k) {
        if (k >= m) {
            return -1;
        }
        // 创建一个统计数词频的数组
        int[] temArr = new int[32];
        // 遍历arr算出每个元素二进制词频,统计到temArr中
        for (int num : arr) {
            for (int i1 = 0; i1 < temArr.length; i1++) {
                // num一次右移 & 1, 这样如果这位是1就是1是0就是0
                temArr[i1] += ((num >> i1) & 1);
            }
        }

        // 定义返回值
        int result = 0;
        // 遍历准备好的数组,如果除以m的余数等于1证明k的这位是1
        for (int i = 0; i < temArr.length; i++) {
            if (temArr[i] % m != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }

    public static int test(int[] arr, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, (oldValue, value) -> oldValue + value);
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) == k) {
                return integer;
            }
        }
        return -1;
    }


    public static int getRandom(int range, Boolean negativeFlag) {
        return negativeFlag ? ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1) : (int) (Math.random() * range) + 1;
    }

    public static void main(String[] args) {
        // 定义需要测试几次
        int testCount = 100000000;
        // 定义M和K最多出现的次数
        int maxM = 10;
        int maxK = 10;
        for (int i = 0; i < testCount; i++) {
            int a = getRandom(maxM, false);
            int b = getRandom(maxK, false);
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k >= m) {
                m = k + 1;
            }
            int[] arr = generateArr(k, m);
            int i1 = find(arr, m, k);
            int i2 = test(arr, m, k);
            if (i1 != i2) {
                System.out.println("自己写的 = " + i1);
                System.out.println("测试的 = " + i2);
                System.out.println("出错啦!!!!!!!!!");
                return;
            }
        }
        System.out.println("测试完成,没有出错哦~~");
    }

    private static int[] generateArr(int k, int m) {
        // 一个数出现了 k 次, 其他数出现了M次
        int kValue = getRandom(100, true);
//        System.out.println("k = " + kValue);

        // 定义其他数,这个其他到底是几个
        int other = getRandom(10, false) + 2;

        // 数组长度 = other * m + k
        int[] arr = new int[other * m + k];

        // 定义HashSet记录每个数出现
        Set<Integer> set = new HashSet<>();

        int i = 0;
        for (; i < k; i++) {
            arr[i] = kValue;
        }
        set.add(kValue);

        while (other != 0) {
            int t;
            do {
                t = getRandom(100, true);
            } while (set.contains(t));
            set.add(t);
            for (int j = 0; j < m; j++) {
                arr[i++] = t;
            }
            other--;
        }
        return arr;
    }
}
