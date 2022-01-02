package easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/
public class _13 {

    public static void main(String[] args) {
        String s = "DCXXI";
        System.out.println(romanToInt(s));
    }

    static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i = 0;
        int res = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'I') {
                if (i+1 < s.length() && s.charAt(i + 1) == 'V') {
                    res = res + 4;
                    i += 2;
                } else if (i+1 < s.length() && s.charAt(i + 1) == 'X') {
                    res = res + 9;
                    i += 2;
                } else {
                    res = res + map.get('I');
                    i++;
                }
            } else if (s.charAt(i) == 'X') {
                if (i+1 < s.length() && s.charAt(i + 1) == 'L') {
                    res = res + 40;
                    i += 2;
                } else if (i+1 < s.length() && s.charAt(i + 1) == 'C') {
                    res = res + 90;
                    i += 2;
                } else {
                    res = res + map.get('X');
                    i++;
                }
            } else if (s.charAt(i) == 'C') {
                if (i+1 < s.length() && s.charAt(i + 1) == 'D') {
                    res = res + 400;
                    i += 2;
                } else if (i+1 < s.length() && s.charAt(i + 1) == 'M') {
                    res = res + 900;
                    i += 2;
                } else {
                    res = res + map.get('C');
                    i++;
                }
            } else {
                res = res + map.get(s.charAt(i));
                i++;
            }
        }
        return res;
    }

}
