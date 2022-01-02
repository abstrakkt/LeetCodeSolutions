package medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class _22 {
    public static void main(String[] args) {
        _22 ob = new _22();
        List<String> list = ob.generateParenthesis(3);
        list.forEach(System.out::println);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        combination(res, n, "", 0, 0);
        return  res;
    }

    private void combination(List<String> res, int max, String current, int open, int closed) {
        if (open + closed == 2 * max) {
            res.add(current);
            return;
        }
        if (open < max) {
            combination(res, max, current + "(", open + 1, closed);
        }
        if (closed < open) {
            combination(res, max, current + ")", open, closed + 1);
        }
    }
}
