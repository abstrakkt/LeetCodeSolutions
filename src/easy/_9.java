package easy;

//https://leetcode.com/problems/palindrome-number/
public class _9 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isPalindromeOpt(int x) {
        int reverse = 0;
        int temp = x;

        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return temp == reverse && temp >= 0;
    }
}
