package leetcode;

class ImplementStrStrNo28 {

    /**
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * Example 1:
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     *
     * Example 2:
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     */

    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.substring(i).startsWith(needle)) {
                return i;
            }
        }
        return -1;
    }

    int strStrOK(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
