package random;

import java.util.Arrays;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/21 11:51
 */
public class RandToRand {
    public static void main(String[] args) {
        int num = 10000000;
        // 证明了随机数每次随机区间内的数字命中概率是相等的
        int[] arr = new int[10];
        for (int i = 0; i < num; i++) {
            int random = (int) (Math.random() * 10);
            arr[random]++;
        }
        System.out.println(Arrays.toString(arr));

        double x = 0.17;
        int count = 0;
        for (int i = 0; i < num; i++) {
            // 如果0.7比两个随机数的最大值还大证明两次随机都是在 0到0.7的区间内
            if (x > xToxPower2()) {
                count++;
            }
        }
        System.out.println((double) count / (double) num);
        System.out.println(Math.pow(x, 2));

    }

    /**
     * [0,1) 0-x 出现的改路是 x
     * 让0-x出现的概率编程x的平方
     */
    public static double xToxPower2() {
        // 随机两次取最大, 如果最大值都 < x 证明两次都随机到了 [0-x) 区间中
        return Math.max(Math.random(), Math.random());
    }
}
