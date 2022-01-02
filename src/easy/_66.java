package easy;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class _66 {
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (++digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
