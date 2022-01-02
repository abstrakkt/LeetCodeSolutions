package easy;

//https://leetcode.com/problems/sqrtx/submissions/
public class _69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(100));
    }

    static int mySqrt_NewtonMethod(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    static int mySqrt(int x) {

        long left = 0;
        long right = x;

        if (x < 2) {
            return x;
        }
        while (left < right) {
            long mid = left + ((right - left) / 2);

            if (mid * mid == x) {
                return (int) mid;

            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) (left - 1);

    }
}
