package or;

/**
 * 不新增变量交换ab
 */
public class Swape {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        System.out.println("交换前 a = " + a + ", b = " + b);

        a = a ^ b;
        // b = a ^ b ^ b = a
        b = a ^ b;
        // a = a ^ b ^ a = b
        a = a ^ b;

        System.out.println("交换后 a = " + a + ", b = " + b);
    }
}
