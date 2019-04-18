package leetcode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("IntelliJ IDEA enjoy it!");
        long startTime = System.currentTimeMillis();
//        no12();
//        no26();
//        no1();
//        no15();
//        no28to29();
//        no6();
//        no3();
//        no13();
//        no11();
        no38();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");
    }

    private static void no3() {
        LengthOfLongestSubstringNo3 solu = new LengthOfLongestSubstringNo3();
        System.out.println(solu.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solu.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(solu.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(solu.lengthOfLongestSubstring("abcd") == 4);
        System.out.println(solu.lengthOfLongestSubstring("dvdf") == 3);
    }
    private static void no6() {

        ZigZagConversionNo6 solu = new ZigZagConversionNo6();
        // PAHNAPLSIIGYIR
        String a = solu.convert("PAYPALISHIRING", 3);
        System.out.println(a + "   run:" + "PAHNAPLSIIGYIR".equals(a));
        // PINALSIGYAHRPI
        a = solu.convert("PAYPALISHIRING", 4);
        System.out.println(a + "   run:" + "PINALSIGYAHRPI".equals(a));

    }
    private static void no12() {
        IntToRomanNo12 solu = new IntToRomanNo12();
        // "III"
        System.out.println(solu.intToRoman(3));
        // "IV"
        System.out.println(solu.intToRoman(4));
        // "IX"
        System.out.println(solu.intToRoman(9));
        // "LVIII"
        System.out.println(solu.intToRoman(58));
        // "MCMXCIV"
        System.out.println(solu.intToRoman(1994));
    }
    private static void no26() {
        RemoveDuplicatesNo26 solu = new RemoveDuplicatesNo26();
        int[] nums = {1, 1, 2};
        // 2
        System.out.println(solu.removeDuplicates(nums));
        // 1 2 ...
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println("");
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // 5
        System.out.println(solu.removeDuplicates2(nums2));
        // 0 1 2 3 4 ...
        for (int j = 0; j < nums2.length; j++) {
            System.out.print(nums2[j]);
        }
        System.out.println("");
        int[] nums3 = {1, 1};
        // 1
        System.out.println(solu.removeDuplicates(nums3));
        // 1 1
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i]);
        }
        System.out.println("");
    }

    private static void no13() {
        RomanToIntNo13 solu = new RomanToIntNo13();
        System.out.println(solu.romanToInt("III") == 3);
        System.out.println(solu.romanToInt("IV") == 4);
        System.out.println(solu.romanToInt("IX") == 9);
        System.out.println(solu.romanToInt("LVIII") == 58);
        System.out.println(solu.romanToInt("MCMXCIV") == 1994);
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

    private static void no38() {

        CountAndSayNo38 solu = new CountAndSayNo38();
        // "1"
        System.out.println(solu.countAndSay(1));
        // "1211"
        System.out.println(solu.countAndSay(4));
    }

    private static void no11() {

        MaxAreaNo11 solu = new MaxAreaNo11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solu.maxArea(height));

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
