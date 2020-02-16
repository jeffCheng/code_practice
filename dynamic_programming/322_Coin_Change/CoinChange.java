
public class CoinChange {

	public static void main(String[] args) {

	}
	
	/**
	 * Input: coins = [1, 2, 5], amount = 11
		Output: 3 
		Explanation: 11 = 5 + 5 + 1
	 * @param coins
	 * @param amount
	 * @return
	 */
	
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int [amount+1];
        dp[0] = 0;
        for(int i= 1;i<dp.length;i++) {
        		dp[i] = amount+1;
        }
        
        for(int i= 1;i< dp.length;i++) {
        		for(int currentCoin: coins) {
        			if(currentCoin<=i) {
        				dp[i] = Math.min(dp[i], dp[i-currentCoin]+1);
        			}
        		}
        }
        return dp[amount]> amount?-1:dp[amount];
    }
    
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<amount+1;i++) dp[i] = amount+1;
        for(int i=1;i<dp.length;i++){
            for(int currCoin:coins){
                if(currCoin<=i) dp[i] = Math.min(dp[i], dp[i-currCoin]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
