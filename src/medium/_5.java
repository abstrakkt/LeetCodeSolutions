package medium;

//https://leetcode.com/problems/longest-palindromic-substring/
public class _5 {
    public static void main(String[] args) {
        _5 obj = new _5();
        String s = "abbdc";
        //System.out.println(s.substring(0, 2));
        System.out.println(obj.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        String sub = "";
        int subLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (s.substring(left, right + 1).length() > subLen) {
                    sub = s.substring(left, right + 1);
                    subLen = s.substring(left, right + 1).length();
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (s.substring(left, right + 1).length() > subLen) {
                    sub = s.substring(left, right + 1);
                    subLen = s.substring(left, right + 1).length();
                }
                left--;
                right++;
            }
        }

        return sub;
    }

    private boolean isPalindrome(String a) {
        int start = 0;
        int end = a.length() - 1;
        while (start < end) {
            if (a.charAt(start) != a.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
