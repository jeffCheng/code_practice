class Solution {
    
    /*
    * Give the index:-1 
    * Find the element value equals zero
    * Give this value as this index
    * if index is not equals -1, then swap 
    */
    public void moveZeroes(int[] nums) {
        int m = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                if(m == -1 || nums[m]!=0) m = i;   
            }else{
                
                    int temp = nums[i];
                    nums[i] = nums[m];
                    nums[m] = temp;
                    m++;
                
            }
        }
    }
}