package easy;//https://leetcode.com/problems/climbing-stairs/

//explanation : https://leetcode.com/problems/climbing-stairs/discuss/241466/Java-Solutions
//https://leetcode.com/problems/climbing-stairs/discuss/1640063/DP-Beginner-Friendly
public class _70 {
    static int[] cache = new int[46]; //since max size of array is given to be 45 in question

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    static int climbStairs(int n) {

        if (n <= 2) {
            return n;
        } else if (cache[n] != 0) {
            return cache[n];
        } else {
            return cache[n] = climbStairs(n - 2) + climbStairs(n - 1);
        }
    }

    static int climbStairsOpt(int n) {
        if (n <= 2)
            return n;

        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
