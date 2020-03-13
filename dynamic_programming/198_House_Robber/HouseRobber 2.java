
public class HouseRobber {

	public static void main(String[] args) {

	}
	
    public int rob(int[] nums) {
        
    		if(nums == null || nums.length ==0) return 0;
    		
    		if(nums.length ==1) return nums[0];
    		
    		int[] dp = new int[nums.length];
    		dp[0] = nums[0];
    		dp[1] =Math.max(nums[0], nums[1]);
    		
    		for(int i =2 ;i<nums.length;i++) {
    			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
    		}
    	
    	
    		return dp[nums.length-1];
    }
    
    public int rob3(int[] nums) {
		if(nums == null || nums.length ==0) return 0;
		if(nums.length ==1) return nums[0];
    	
    		int max1 = robHelper(nums,0,nums.length-2);
    		int max2 = robHelper(nums,1,nums.length-1);
    	
    		return Math.max(max1, max2);
    }
    
    public int robHelper(int[] nums, int i, int j) {
    		if(i==j) return nums[i];
            int[] dp = new int[nums.length];
            dp[i]=nums[i];
            dp[i+1]=Math.max(nums[i+1], dp[i]);
            for(int k=i+2; k<=j; k++){
                dp[k]=Math.max(dp[k-1], dp[k-2]+nums[k]);    
            }
         
            return dp[j];
    }
}
