package easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class _26 {
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[++ans] = nums[i + 1];
            }
        }
        return ans + 1;
    }
}
