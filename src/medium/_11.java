package medium;

//https://leetcode.com/problems/container-with-most-water/
public class _11 {

    public static void main(String[] args) {
        //int[] heights = {1, 1};
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(heights));
    }

    static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int area = 0;
            for (int j = i + 1; j < height.length; j++) {
                area = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    static int maxAreaOpt(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int length = Math.min(height[start], height[end]);
            int width = end - start;
            maxArea = Math.max(maxArea, length * width);
            while (start < end && height[start] <= length) {
                start++;
            }
            while (start < end && height[end] <= length) {
                end--;
            }
        }

        return maxArea;
    }
}
