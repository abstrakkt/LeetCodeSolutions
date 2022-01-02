package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/majority-element/
public class _169 {
    public static void main(String[] args) {
        int[] ar = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(ar));
    }

    static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Integer m = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).findFirst().map(e -> e.getKey()).get();
        return (int) m;
    }

    //O(nlogN)
    static int majorityElementOpt(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len / 2];
    }

    //O(n)
    //https://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
    static int majorityElementOpt2(int[] num) {
        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }
}
