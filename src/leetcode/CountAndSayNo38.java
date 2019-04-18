package leetcode;

class CountAndSayNo38 {

    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        char[] arrays = countAndSay(n - 1).toCharArray();
        char tmp = arrays[0];
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arrays.length; i++) {
            if (tmp != arrays[i]) {
                result.append(count).append(tmp);
                tmp = arrays[i];
                count = 1;
            } else {
                count++;
            }
        }
        return count > 0 ? result.append(count).append(tmp).toString() : "";
    }
}
