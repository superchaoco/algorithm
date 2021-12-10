package or;

/**
 * 有两种数是奇数,其他数都是偶数,找到这两种奇数
 */
public class TwoKinds {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6};


        // 定义eor 最后一定 = 1 ^ 2
        int eor = 0;
        // 让eor亦或每一个数, 等同于 1 ^ 1 ^ 1 ^ 2 ^ 3 ^ 3 ^ 4 ^ 4 ^ 5 ^ 5 ^ 6 ^ 6 = 1 ^ 2
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // 找到 1 ^ 2 上的结果的二进制最右面的1
        // == > 这个1代表两种数这个位置肯定不同 要么一个为1一个为0,要么一个为0一个为1,因为不同才为1
        // 所以数组中的数可以分为两种,这个位置上为1的和这个位置上不为1的
        // 把这个位置上为1的全取出来用一个新的eor去依次异或运算,两种数一个为1一个不为1就分开了,有因为其他数出现次数是偶数次所以eor一定为两种数中的一种
        int eor2 = 0;
        // 找到eor为1的位数
        int right1 = eor & (~eor + 1);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & right1) != 0) {
                eor2 ^= arr[i];
            }
        }
        System.out.println("两种数分别为" + eor2 + "和" + (eor ^ eor2));
    }
}
