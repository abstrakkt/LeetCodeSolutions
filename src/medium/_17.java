package medium;

import java.util.*;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class _17 {

    private Map<Character, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        _17 obj = new _17();
        List<String> ls = obj.letterCombinations("234");
        ls.forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {
        populateMap();

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        findCombinations(result, digits, "", 0);
        return result;
    }

    private void findCombinations(List<String> result, String digits, String current, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        Character c = digits.charAt(index);
        List<String> list = map.get(c);
        for (String s : list) {
            findCombinations(result, digits, current + s, index + 1);
        }
    }


    private void populateMap() {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }
}
