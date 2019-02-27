package leetcode;

import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstringNo3 {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * <p>
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * <p>
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
// dvdf out2 Expected3
//    public int lengthOfLongestSubstring(String s) {
//        HashMap<Integer, Character> mapSet = new HashMap<>();
//        int MaxCnt = 0;
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (mapSet.containsValue(s.charAt(i))) {
//                mapSet = new HashMap<>();
//                mapSet.put(i, s.charAt(i));
//                MaxCnt = MaxCnt < count ? count : MaxCnt;
//                count = 1;
//            } else {
//                count++;
//                mapSet.put(i, s.charAt(i));
//            }
//        }
//        MaxCnt = MaxCnt < count ? count : MaxCnt;
//        return MaxCnt;
//    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
