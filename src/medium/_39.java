package medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//solution : https://www.youtube.com/watch?v=yFfv03AE_vA
public class _39 {
    public static void main(String[] args) {
        _39 obj = new _39();
        int[] arr = {0, 1, 2, 3, 4, 5};
        List<List<Integer>> res = obj.combinationSum(arr, 7);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getCombination(0, candidates, target, result, new ArrayList<Integer>());
        return result;
    }

    private void getCombination(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> list) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            System.out.println(list);
            result.add(list);
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            getCombination(i, candidates, target - candidates[i], result, list);
            list.remove(list.size() - 1);
        }
    }

}
