package leetcode;

import java.util.LinkedList;
import java.util.List;

public class ZigZagConversionNo6 {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */
    public String convert(String s, int numRows) {
        List<StringBuilder> readList = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder read = new StringBuilder();
            readList.add(read);
        }
        int readRow = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (readRow == numRows - 1) {
                flag = false;
            } else if (readRow == 0) {
                flag = true;
            }
            readList.get(readRow).append(s.charAt(i));
            if (numRows != 1) {
                if (flag) {
                    readRow++;
                } else {
                    readRow--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder reads : readList) {
            result.append(reads);
        }
        return result.toString();
    }
//    public String convert(String s, int numRows) {
//        if ("".equals(s)) {
//            return "";
//        }
//        if(numRows==0||numRows==1){
//            return s;
//        }
//        char[] totalChars = s.toCharArray();
//        int length = totalChars.length;
//        /*每列加后面的弯弯算做一个chunk，一个chunk包含chunkNums个char*/
//        int chunkNums = numRows * 2 - 2;
//        /*一共有多少个chunk*/
//        int chunks = length / chunkNums + 1;
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j < numRows; j++) {
//            if (j == 0) {
//                /*第一种情况：*/
//                for (int i = 0; i < chunks; i++) {
//                    int index = i * chunkNums;
//                    if (index < length) {
//                        sb.append(totalChars[index]);
//                    }
//                }
//            } else if (j == numRows - 1) {
//                /*这两种情况只有一个*/
//                for (int i = 0; i < chunks; i++) {
//                    int index = i * chunkNums + (numRows - 1);
//                    if (index < length) {
//                        sb.append(totalChars[index]);
//                    }
//                }
//            } else {
//                /*否则有两个*/
//                for (int i = 0; i < chunks; i++) {
//                    int firstIndex = i * chunkNums + j;
//                    int secondIndex = i * chunkNums + (chunkNums - j);
//                    if (firstIndex < length) {
//                        sb.append(totalChars[firstIndex]);
//                    }
//                    if (secondIndex < length) {
//                        sb.append(totalChars[secondIndex]);
//                    }
//                }
//            }
//        }
//        return sb.toString();
//    }

//    public String convert(String s, int numRows) {
//
//        if (numRows == 1) return s;
//
//        List<StringBuilder> rows = new ArrayList<>();
//        for (int i = 0; i < Math.min(numRows, s.length()); i++)
//            rows.add(new StringBuilder());
//
//        int curRow = 0;
//        boolean goingDown = false;
//
//        for (char c : s.toCharArray()) {
//            rows.get(curRow).append(c);
//            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
//            curRow += goingDown ? 1 : -1;
//        }
//
//        StringBuilder ret = new StringBuilder();
//        for (StringBuilder row : rows) ret.append(row);
//        return ret.toString();
//    }
//    public String convert(String s, int numRows) {
//
//        if (numRows == 1) return s;
//
//        StringBuilder ret = new StringBuilder();
//        int n = s.length();
//        int cycleLen = 2 * numRows - 2;
//
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j + i < n; j += cycleLen) {
//                ret.append(s.charAt(j + i));
//                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
//                    ret.append(s.charAt(j + cycleLen - i));
//            }
//        }
//        return ret.toString();
//    }
}
