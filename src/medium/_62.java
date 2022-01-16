package medium;

//https://leetcode.com/problems/unique-paths/
public class _62 {
    public static void main(String[] args) {
        _62 obj = new _62();
        System.out.println(obj.uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(m - 1, n - 1, new int[n][m]);
    }

    private int uniquePathsHelper(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else if (memo[n][m] > 0) {
            return memo[n][m];
        } else {
            memo[n][m] = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);
            return memo[n][m];
        }
    }
}
