
public class BestTimeBuySellStock {

	/**
	 * Input: [7, 1, 5, 3, 6, 4] Output: 5
	 * 
	 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
	 * than buying price)
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	public static int maxProfit(int[] prices) {
		int resultNum = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				// if(j>=i)
				resultNum = Math.max(resultNum, prices[j] - prices[i]);
			}
		}
		return resultNum;
	}

	public static int maxProfit1(int[] prices) {

		if (prices == null || prices.length <= 1)
			return 0;

		int minBuy = prices[0];
		int maxProfit = prices[1] - prices[0];

		for (int i = 2; i < prices.length; i++) {
			minBuy = Math.min(prices[i - 1], minBuy);
			maxProfit = Math.max(maxProfit, prices[i] - minBuy);
		}

		if (maxProfit < 0)
			return 0;

		return maxProfit;
	}

	public static int maxProfit2(int[] prices) {

		if (prices == null || prices.length <= 1)
			return 0;

		int sum = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[i - 1] > 0) {
				sum += prices[i] - prices[i - 1];
			}
		}

		return sum;
	}

	public static int maxProfit3(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		left[0] = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}

		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}

		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}

		return profit;
	}

	public int maxProfit4(int[] prices, int fee) {
		if (prices == null || prices.length == 0)
			return 0;

		int[] curProfit = new int[prices.length];
		int[] maxProfit = new int[prices.length];
		maxProfit[0] = -fee;
		for (int i = 1; i < prices.length; ++i) {
			int diff = prices[i]-prices[i-1];
			curProfit[i] = Math.max(curProfit[i - 1], maxProfit[i - 1] );
			maxProfit[i] = Math.max(curProfit[i - 1]+diff -fee, maxProfit[i - 1]+diff);
		}
		return Math.max(curProfit[prices.length-1], maxProfit[prices.length-1]);

	}

}
