package leetcode;

public class RemoveDuplicatesNo26 {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * Given nums = [1,1,2],return length = 2, with the first two elements of nums being 1 and 2 respectively.
     * Given nums = [0,0,1,1,1,2,2,3,3,4],return length = 5,
     * with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
     */
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        int tmp = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                tmp = nums[i];
                cnt++;
                continue;
            }
            if (nums[i] == tmp) {
                do {
                    i++;
                } while (i < nums.length && nums[i] == tmp);
            }
            if (i < nums.length) {
                nums[count++] = nums[i];
                cnt++;
                tmp = nums[i];
            }
        }
        return cnt;
    }
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums.length;
        }

        int i = 1, j = 0;
        while (i < nums.length) {
            if (nums[i - 1] != nums[i]) {
                nums[++j] = nums[i];
            }
            i++;
        }

        return j + 1;
    }
}
