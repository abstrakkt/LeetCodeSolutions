package easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class _448 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers(arr).forEach(System.out::println);
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (i != correctIndex && nums[correctIndex] != correctIndex + 1) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] - 1 != j) {
                list.add(j + 1);
            }
        }

        return list;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
