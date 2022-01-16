package medium;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class _31 {

    public static void main(String[] args) {
        _31 obj = new _31();
        int[] arr = {1, 3, 2};
        obj.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] A) {
        int n = A.length - 1;
        int i = n - 1;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n;
            while (A[j] <= A[i]) {
                j--;
            }
            swap(A, i, j);
        }
        reverse(A, i + 1, n);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) {
            swap(A, i++, j--);
        }
    }
}
