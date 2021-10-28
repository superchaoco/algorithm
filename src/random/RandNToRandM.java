package random;

import java.util.Arrays;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/21 11:51
 */
public class RandNToRandM {
    public static void main(String[] args) {
        int[] arr = new int[59];
        for (int i = 0; i < 10000000; i++) {
            arr[RandNToRandM.g()]++;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 生产[7-46]之间的随机数 * 40 + 7        [0,1) * 40 [0,40) + 7 [7,47) = [7-46]
     *
     * @return [1-5]之间的随机数
     */
    private static int fun1() {
        return (int) (Math.random() * 40 + 7);
    }

    /**
     * 只能使用fun1 的情况下的一个[0,1]的随机数 7 - 26  27 = 46
     *
     * @return 随机等概率返回0 1
     */
    private static int fun2() {
        int i  = fun1();
        return i <= 26 ? 0 : 1;
    }

    /**
     * 随机返回 [12-58]之间的随机数
     *
     * @return [12-58]之间的随机数
     */
    private static int fun4() {
        // [12,58] 之间的随机数可以想成 [0,46] + 12
        // 二进制位数所能表述的十进制 2的N次方 - 1 N就是位数, 当前位数应该是 6 -- > 能表述63以内的十进制
        return (fun2() << 6) + (fun2() << 5) + (fun2() << 4) + (fun2() << 3) + (fun2() << 2) + (fun2() << 1) + fun2();
    }

    /**
     * 随机返回 [0-7]之间的随机数
     *
     * @return [0-7]之间的随机数
     */
    private static int g() {
        int i;
        do {
            i = fun4();
        } while (i > 46);
        return i + 12;
    }


}
