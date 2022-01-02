package easy;

import java.util.Stack;

//https://leetcode.com/problems/add-binary/
public class _67 {
    public static void main(String[] args) {
        System.out.println(anotherAdd("1010", "1011"));
    }

    static String binary(String a, String b) {
        Long x = Long.parseLong(a, 2);
        Long y = Long.parseLong(b, 2);
        Long res = x + y;
        return Long.toBinaryString(res);
    }

    static String anotherAdd(String a, String b) {
        if (a == null || b == null) return "";
        int first = a.length() - 1;
        int second = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (first >= 0 || second >= 0) {
            int sum = carry;
            if (first >= 0) {
                sum += a.charAt(first) - '0';
                first--;
            }
            if (second >= 0) {
                sum += b.charAt(second) - '0';
                second--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            sb.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0)
            sb.append('1');

        sb.reverse();
        return String.valueOf(sb);
    }

    static String addBinary(String a, String b) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        Stack<Character> res = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            st1.push(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            st2.push(b.charAt(i));
        }

        char carry = 0;
        while (!st1.isEmpty() || !st2.isEmpty()) {
            if (!st1.isEmpty() && !st2.isEmpty()) {
                if (st1.peek() == '0' && st2.peek() == '0') {
                    if (carry == 0) {
                        res.push('0');
                    } else {
                        res.push('1');
                        carry = 0;
                    }
                } else if (st1.peek() == '1' && st2.peek() == '0') {
                    if (carry == 0) {
                        res.push('1');
                    } else {
                        res.push('0');
                        carry = 1;
                    }
                } else if (st1.peek() == '0' && st2.peek() == '1') {
                    if (carry == 0) {
                        res.push('1');
                    } else {
                        res.push('0');
                        carry = 1;
                    }
                } else {
                    if (carry == 0) {
                        res.push('0');
                        carry = 1;
                    } else {
                        res.push('1');
                        carry = 1;
                    }
                }
                st1.pop();
                st2.pop();
            } else if (st1.isEmpty() && !st2.isEmpty()) {
                if (carry == 0 && st2.peek() == '0') {
                    res.push('0');
                } else if (carry == 0 && st2.peek() == '1') {
                    res.push('1');
                } else if (carry == 1 && st2.peek() == '0') {
                    res.push('1');
                    carry = 0;
                } else {
                    res.push('0');
                    carry = 1;
                }
                st2.pop();
            } else if (st2.isEmpty() && !st1.isEmpty()) {
                if (carry == 0 && st1.peek() == '0') {
                    res.push('0');
                } else if (carry == 0 && st1.peek() == '1') {
                    res.push('1');
                } else if (carry == 1 && st1.peek() == '0') {
                    res.push('1');
                    carry = 0;
                } else {
                    res.push('0');
                    carry = 1;
                }
                st1.pop();
            }
        }
        if (carry == 1) {
            res.push('1');
        }
        String str = "";
        while (!res.isEmpty()) {
            str = str + res.peek();
            res.pop();
        }
        return str;
    }
}
