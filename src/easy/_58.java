package easy;

//https://leetcode.com/problems/length-of-last-word/
public class _58 {
    public int lengthOfLastWord(String s) {
        String[] ar = s.trim().split(" ");
        return ar[ar.length - 1].length();
    }
}
