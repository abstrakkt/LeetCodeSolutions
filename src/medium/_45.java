package medium;

//https://leetcode.com/problems/jump-game-ii/
public class _45 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 0, 1, 4};
        System.out.println(jumpOpt(arr));
    }

    static int jump(int[] nums) {
        int curr = nums.length - 1;
        int count = 0;
        int min = nums.length;
        while (curr > 0) {
            for (int i = curr - 1; i >= 0; i--) {
                if (i + nums[i] >= curr) {
                    min = Math.min(min, i);
                }
            }
            count++;
            curr = min;
        }
        return count;
    }

    static int jumpOpt(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
