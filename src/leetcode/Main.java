package leetcode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("IntelliJ IDEA enjoy it!");
        no1();
        no15();
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

    private static void no15() {

        Three3SumNo15 solu = new Three3SumNo15();
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solu.threeSum(num);
        System.out.println("aaa");
    }

    private static void no1() {

        TwoSumNo1 solu = new TwoSumNo1();
        int[] num = {2, 7, 11, 15};
        int[] num2 = {5, 75, 25};
        int[] num3 = {3, 3};
        int[] numRst = solu.twoSum(num, 9);
        for (int i : numRst) {
            System.out.println(i);
        }
        int[] numRst2 = solu.twoSum(num2, 100);
        for (int j : numRst2) {
            System.out.println(j);
        }
        int[] numRst3 = solu.twoSum(num3, 6);
        for (int k : numRst3) {
            System.out.println(k);
        }
    }
}
