package easy;

//https://leetcode.com/problems/maximum-subarray/
public class _53 {
    public static void main(String[] args) {
        int[] nums = {-2, -1, -4, -6};
        System.out.println(maxSubArray(nums));
    }

    // nums = [-2,1,-3,4,-1,2,1,-5,4]
    static int maxSubArray(int[] nums) {
        int tempSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempSum = tempSum + nums[i];
            max = Math.max(tempSum, max);
            if (tempSum < 0)
                tempSum = 0;
        }
        return max;
    }
}
