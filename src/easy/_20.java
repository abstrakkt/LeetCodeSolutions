package easy;

import java.util.Stack;

//https://leetcode.com/problems/longest-common-prefix/
public class _20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!st.isEmpty()) {
                if ((st.peek() == '(' && s.charAt(i) == ')')
                        || (st.peek() == '{' && s.charAt(i) == '}')
                        || (st.peek() == '[' && s.charAt(i) == ']')) {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
