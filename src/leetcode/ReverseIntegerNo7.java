package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReverseIntegerNo7 {
    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * Example 1:
     * Input: 123
     * Output: 321
     * Example 2:
     * Input: -123
     * Output: -321
     * Example 3:
     * Input: 120
     * Output: 21
     * 32-bit -2 の32位の場合、returns 0
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
