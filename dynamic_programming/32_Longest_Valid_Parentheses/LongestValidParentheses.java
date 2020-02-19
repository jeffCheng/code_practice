class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        int left = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }else if(left>0){
                dp[i] = dp[i-1]+2;
                dp[i]+=(i-dp[i]>0)? dp[i-dp[i]]: 0;
                res = Math.max(res, dp[i]);
                left--;
            }
        }
        return res;
    }
}