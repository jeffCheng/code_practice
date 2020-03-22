class Solution {
    /*
    1. without division 
    2. new array 
    */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        
        int[] res = new int[nums.length];
        res[0] =1;
        
        //from the begining to the end
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        
        int move = 1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] = move*res[i];
            move = move*nums[i];
        }
        return res;
    }
}