package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/3sum/
public class _15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            index.put(nums[i], i);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = 0 - (nums[i] + nums[j]);
                if (index.containsKey(target) && index.get(target) > j) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                    j = index.get(nums[j]);

                }
                i = index.get(nums[i]);
            }
        }
        return res;
    }

}
