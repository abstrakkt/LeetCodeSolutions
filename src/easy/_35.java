package easy;

public class _35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start > end)
            return start;
        return 0;
    }
}
