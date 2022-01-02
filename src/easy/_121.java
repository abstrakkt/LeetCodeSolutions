package easy;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _121 {
    public static void main(String[] args) {
        //int[] ar = {7, 1, 5, 3, 6, 4};
        //System.out.println(maxProfit(ar));
        List<Integer> list = Arrays.asList(7, 1, 5, 3, 6, 4);
        System.out.println(stockmax(list));
    }

    static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int profit = prices[i] - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    //https://www.hackerrank.com/challenges/stockmax/problem
    static long stockmax(List<Integer> prices) {
        int n = prices.size() - 1;
        long profit = 0L;
        int max = 0;
        for (int i = n; i >= 0; i--) {
            if (prices.get(i) > max) {
                max = prices.get(i);
            }
            profit = profit + max - prices.get(i);
        }
        return profit;
    }
}
