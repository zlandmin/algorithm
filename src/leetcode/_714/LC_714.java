package leetcode._714;

/*
714. Best Time to Buy and Sell Stock with Transaction Fee
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class LC_714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] hold = new int[n];
        int[] unhold = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                hold[i] = Math.max(hold[i - 1], -prices[1]);
            } else {
                hold[i] = Math.max(hold[i - 1], unhold[i - 1] - prices[i]);
            }
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return unhold[n - 1];
    }
}
