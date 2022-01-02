package easy;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class _88 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                i++;
                k++;
            } else {
                res[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            res[k] = nums1[i];
            k++;
            i++;
        }
        while (j < n) {
            res[k] = nums2[j];
            k++;
            j++;
        }

        for (int l = 0; l < nums1.length; l++) {
            nums1[l] = res[l];
        }
    }
}
