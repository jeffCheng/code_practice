class Solution {


    /**
     * https://leetcode.com/problems/shuffle-an-array/
     * https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
     * https://algorithm.yuanbin.me/zh-tw/basics_algorithm/probability/shuffle.html
     */
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] newArr = new int[nums.length];
        for(int i=0;i<nums.length;i++) newArr[i] = nums[i];
        
        Random rand = new Random();
        for(int i=0;i<nums.length;i++){
            int k = rand.nextInt(i+1);
            int temp = newArr[i];
            newArr[i] = newArr[k];
            newArr[k] = temp;
        }
        return newArr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */