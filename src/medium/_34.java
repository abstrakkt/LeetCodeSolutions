package medium;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class _34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    private int binarySearch(int[] nums, int target, boolean startIndex) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (startIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }
}
