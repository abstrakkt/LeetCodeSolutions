package medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
//https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
public class _46 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = permute(arr);
        System.out.println(res);
    }

    private static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        finder(arr, result, new ArrayList<Integer>());
        return result;
    }

    private static void finder(int[] arr, List<List<Integer>> result, List<Integer> tempList) {
        if (tempList.size() == arr.length) {
            result.add(new ArrayList<>(tempList));
            return;
        } else {

            for (int i = 0; i < arr.length; i++) {
                if (tempList.contains(arr[i]))
                    continue;
                tempList.add(arr[i]);
                finder(arr, result, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
