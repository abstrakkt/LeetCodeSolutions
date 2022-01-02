package medium;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class _33 {

    public static void main(String[] args) {
        int[] ar = {1, 3};
        int target = 1;
        _33 obj = new _33();
        System.out.println(obj.search(ar, target));
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                if (target <= nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (nums[mid] <= nums[end]) {
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    //Alternative
    public int searchAlter(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int pivot = left;
        int start = 0;
        int end = nums.length - 1;

        if (target >= nums[pivot] && target <= nums[start]) {
            start = pivot;
        } else {
            end = pivot;
        }

        return binarySearch(nums, target, start, end);

    }

    private int binarySearch(int[] temp, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (temp[mid] == target) {
                return mid;
            } else if (temp[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
