package random;

import java.util.Arrays;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/21 11:51
 */
public class Rand0ToRand1 {
    public static void main(String[] args) {
        int[] arr = new int[2];
        for (int i = 0; i < 10000000; i++) {
            arr[Rand0ToRand1.funB()]++;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 0.75 概率返回 0 , 0.25概率返回1
     *
     * @return
     */
    public static int funA() {
        return Math.random() < 0.75 ? 0 : 1;
    }

    /**
     * 根据FunA 等概率返回0和1
     *
     * @return
     */
    public static int funB() {
        // 随机 00或者随机11的概率不一样但是 随机两次,随机到 0 1 概率 和 1 0 概率一样
        int num;
        do {
            num = funA();
        } while (num == funA());
        return num;
    }

}
