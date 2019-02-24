package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumNo1 {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * Example:
     * <p>
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        int[] numsSort = nums.clone();
//        Arrays.sort(numsSort);
//        int j = nums.length - 1;
//        for (int i = 0; i < nums.length - 1; ) {
//            if (numsSort[i] + numsSort[j] == target) {
//                result[0] = Arrays.binarySearch(nums, numsSort[i]);
//                result[1] = Arrays.binarySearch(nums, numsSort[j]);
//                break;
//            } else if (numsSort[i] + numsSort[j] < target) {
//                i++;
//            } else {
//                j--;
//            }
//        }
//        return result;
//    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
