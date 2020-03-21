class Solution {
    /*
    Divide nad conquer problems
    1. Define the base cases.
    2. Split the problem into subproblems and solve them recursively
    3. Merge the solutions for the subproblems to obtain the solution for the original problem
    */
    public int maxSubArray(int[] nums) {
        return helper(nums, 0 , nums.length -1);
    }
    
    public int helper(int[] nums, int left , int right){
        if(left == right) return nums[left];
        
        int mid = left + (right-left)/2;
        
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid+1,right);
        int crossSum = crossSum(nums, left, right , mid);
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    
    public int crossSum(int[] nums , int left , int right , int mid) {
        if(left == right) return nums[left];
        
        int leftSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = mid; i>= left;i--){
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }
        
        int rightSum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i= mid+1;i<=right;i++){
            currSum+= nums[i];
            rightSum = Math.max(rightSum, currSum);
        }
        return leftSum + rightSum;
    }
}