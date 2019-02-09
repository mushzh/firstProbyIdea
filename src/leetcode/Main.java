package leetcode;

public class Main {
    public static void main(String[] args) {
        System.out.println("IntelliJ IDEA enjoy it!");
        no28to29();

    }
    private static void no28to29() {

        ImplementStrStrNo28 solu = new ImplementStrStrNo28();
        System.out.println(solu.strStrOK("hello", "ll"));
        System.out.println(solu.strStrOK("abbca", "bba"));
        DivideTwoIntegersNo29 solu2 = new DivideTwoIntegersNo29();
        System.out.println(solu2.divide(10, 3));
        System.out.println(solu2.divide(7, -3));
        System.out.println(solu2.divide(-1, -1));
        System.out.println(solu2.divide(-2147483648, -1));
    }
}
