package operation;

public class TestMain {

    public static void main(String[] args) {
//        System.out.println(add(1, 2));
//        System.out.println(add(2, 3));
//        System.out.println(sub(3, 4));
//        System.out.println(sub(4, 5));
//        System.out.println("===============");
//        System.out.println(multi(5, -6));
//        System.out.println(multi(6, 7));
//        System.out.println("===============");
//        System.out.println(div(7, 8));
//        System.out.println(div(8, 9));
//        System.out.println(div(7, 8));
//        System.out.println(div(7, 7));
        System.out.println(divide(-2147483648, -1));

    }


    /**
     * 整体思路就是, a,b无符号相加得到a1,然后求出a,b相加进位数b1 << 1
     * a1,b1 无符号相加得到a2,然后再求出a1,b1相加进位数b2 << 1
     * 然后 a1,b1重复操作得到a2,b2 ...
     * 依次循环直到进位数为0
     *
     * @param a 整数a
     * @param b 整数b
     * @return a + b
     */
    private static int add(int a, int b) {
        int sum = 0;
        while (b != 0) {
            // a ^ b 实际上就是无符号相加
            sum = a ^ b;
            // a & b 都为1才为1 == > 都为1才需要进位 == > 左移一位(想想现实中的加法就知道为啥左移一位了)
            // 此时b代表进位数
            b = (a & b) << 1;
            // 此时a代表无符号相加后的结果
            a = sum;
        }
        return sum;
    }

    /**
     * a-b = a + (-b)
     * -b = b取反加一
     *
     * @param a 整数a
     * @param b 整数b
     * @return a - b
     */
    private static int sub(int a, int b) {
        return add(a, add(~b, 1));
    }

    /**
     * 整体思路就是把b所有位数都遍历一遍没遍历一次a补零
     * 如果b位上是1把a记录下来,最终结果就是所有b是1的时候的a的和
     *
     * @param a 整数a
     * @param b 整数b
     * @return a * b
     */
    private static int multi(int a, int b) {
        int res = 0;

        while (b != 0) {
            if ((b & 1) != 0) {
                // 如果当前2进制为最右面 = 1, 此时的a就要参与累加
                res = add(res, a);
            }
            // 每循环一次b右移一次 !!!注意是无符号右移
            b >>>= 1;
            // 每循环一次a左移补一次0
            a <<= 1;
        }
        return res;
    }

    /**
     * a / b 是a遍历31次(符号位不参与遍历),遍历过程中如果a右移后如果>=b
     * 那么最终结果这个位上肯定是1,让a变成b左移索引位数在参与循环,描述起来比较复杂
     * talk is cheap ,show me your code
     * <p>
     * 举例子第一次是 .... 0000 0000
     * 第一次发现在a右移3位时找到了最接近a的b那么 res = .... 0000 0000  | 0000 1000 res = 0000 1000
     * 第二次发现在a右移2位时找到了最接近a(a已经不是原来的a了)的b那么 res = .... 0000 1000  | 0000 0100 res = 0000 1100
     *
     * @param a 整数a
     * @param b 整数b
     * @return a / b
     */
    private static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            // 没有系统最大值对应,因为系统最大是系统最小-1表示不了
            return Integer.MAX_VALUE;
        } else if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        } else if (a == Integer.MIN_VALUE) {
            // 把a转成 系统最大然后求出结果
            int res = divHandler(add(a, 1), b);
            // 最终结果要 加上(a -  res * b) / b 进行补偿
            return add(res, divHandler(sub(a, multi(res, b)), b));
        } else {
            return divHandler(a, b);
        }
    }

    private static int divHandler(int a, int b) {
        // 把a,b转成正数
        int x = a < 0 ? add(~a, 1) : a;
        int y = b < 0 ? add(~b, 1) : b;

        int res = 0;

        // 遍历31次 == > 忽略符号位
        for (int i = 30; i >= 0; i = sub(i, 1)) {
            // 如果a右移后比b大记录下来
            if ((x >> i) >= y) {
                // 这个位标记成1
                res |= (1 << i);
                // a =  a - b左移i位
                x = sub(x, y << i);
            }
        }
        return (a < 0) ^ (b < 0) ? add(~res, 1) : res;
    }

}
