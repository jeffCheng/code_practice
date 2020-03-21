class Solution {
    public int maxSubArray(int[] nums) {
        int currNum = nums[0];
        int sum = nums[0];
        
        for(int i=1;i<nums.length;i++){
            currNum = Math.max(currNum+nums[i], nums[i]);
            sum = Math.max(sum, currNum);
        }
        return sum;
    }
}