package random;

import java.util.Arrays;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/21 11:51
 */
public class Rand5ToRand7 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 10000000; i++) {
            arr[Rand5ToRand7.g()]++;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 生产[1-5]之间的随机数
     *
     * @return [1-5]之间的随机数
     */
    private static int fun1() {
        return ((int) (Math.random() * 5)) + 1;
    }

    /**
     * 只能使用fun1 的情况下的一个[0,1]的随机数
     *
     * @return 随机等概率返回0 1
     */
    private static int fun2() {
        int i;
        do {
            i = fun1();
        } while (i == 3);
        return i <= 2 ? 0 : 1;
    }

    /**
     * 随机返回 [0-7]之间的随机数
     *
     * @return [0-7]之间的随机数
     */
    public static int fun3() {
        int i = fun2();
        int i1 = fun2();
        int i2 = fun2();
        int ia = (i == 0 ? 0 : 2 * 2);
        int ib = (i1 == 0 ? 0 : 2);
        return ia + ib + i2;
    }

    /**
     * 随机返回 [0-7]之间的随机数
     *
     * @return [0-7]之间的随机数
     */
    private static int fun4() {
        // [0 - 7] 随机数就是 000 - 111 每个二进制位上的随机, 求出二进制在转成十进制就是 [0-7]上的随机数
        return (fun2() << 2) + (fun2() << 1) + fun2();
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
        }while (i == 0);
        return i;
    }


}
