package easy;

//https://leetcode.com/problems/single-number/
public class _136 {

    public int singleNumber(int[] nums) {
        int ans = 0;

        int len = nums.length;
        for (int i = 0; i != len; i++)
            ans ^= nums[i];  //0^N = N | N^N = 0; bitwise XOR

        return ans;
    }

}
