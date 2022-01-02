package easy;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class _283 {

    public static void main(String[] args) {
        int[] ar = {0,1,0,3,12};
        moveZeroes(ar);
        System.out.println(Arrays.toString(ar));
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}