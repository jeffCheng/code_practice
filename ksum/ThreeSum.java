class Solution {
    /**
     * 1. firstly, we need to sort this array
     * 2. give a pivot as index 
     * 3. start and end point to two pointer search 
     * 4. sum - nums[i] = left + right
     * 5. do not need duplicate value, so we ignore the duplicated -> while(left<right && nums[right] == nums[right-1]) right--;
     * 6. i == 0 || nums[i] != nums[i-1] to remove duplicated one.
     * 7. time complexity will be n square
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //we need to sort array because we use two pointer.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){ // two pointer start and end point
            if(i== 0 || (i>0 &&nums[i] != nums[i-1])){ //we can simply put as if(i==0 ||nums[i]!= nums[i-1])
                int left = i+1; // not incluided index i
                int right = nums.length -1; // just give the last index
                int sum = 0 - nums[i];
                while(left<right){
                    if(nums[left]+nums[right] == sum){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        temp.add(nums[i]);
                        res.add(temp);
                        while(left<right && nums[left] == nums[left+1]) left++;
                        while(left<right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }else if(nums[left]+nums[right] < sum){
                        while(left<right && nums[left] == nums[left+1]) left++; //we may not need to this.
                        left++;
                    }else if(nums[left]+nums[right] > sum){
                        while(left<right && nums[right] == nums[right-1]) right--; //we may not need to this.
                        right--;
                    }
                }
            }
        }
        return res;
    }
}