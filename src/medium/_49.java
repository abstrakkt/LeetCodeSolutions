package medium;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class _49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ar = strs[i].toCharArray();
            Arrays.sort(ar);
            String key = String.valueOf(ar);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
