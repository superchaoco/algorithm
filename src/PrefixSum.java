import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/20 14:27
 */
public class PrefixSum {
    private static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    private static int[] prefixArray;

    private static int length = arr.length;

    static {
        prefixArray = new int[length];
        prefixArray[0] = arr[0];
        // 给前缀和数组赋值
        for (int i = 1; i < length; i++) {
            prefixArray[i] = arr[i] + prefixArray[i - 1];
        }
    }

    /**
     * 计算 arr 从N ~ M 下标总和
     *
     * @param n 起始位置
     * @param m 结束位置
     * @return -1代表参数错误
     */
    public static int sum(int n, int m) {
        if (n > m || m > length) {
            return -1;
        }
        // 假设目标数组是T 前缀和数组是P
        // P0 索引位置数据 = T0
        // P1 索引位置数据 = T0 + T1
        // P2 索引位置数据 = T0 + T1 + T2
        // P3 索引位置数据 = T0 + T1 + T2 + T3
        // ... ...
        // PN 索引位置数据 = T0 + T1 + T2 + T3 + ... + TN
        // 所以要求 T N~M 之间的和其实就是 P M - P(N-1)
        return n == 0 ? prefixArray[m] : prefixArray[m] - prefixArray[n - 1];

    }


    public static void main(String[] args) {
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        System.out.println(sum(1, 4));
        // 打印数组
        System.out.println(Arrays.toString(prefixArray));

    }
}
