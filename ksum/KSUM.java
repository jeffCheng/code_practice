class KSUM {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        kSum(res, new ArrayList<Integer>(), target, 4, 0, nums.length-1, nums);
        return res;
    }
    
    private void kSum(List<List<Integer>> res , List<Integer> temp, int target , int k, int left, int right, int[] nums){
        if(k == 0 || nums.length == 0 || left>right) return;
        if(k == 1){
            for(int i=left;i<=right;i++){
                if(nums[i] == target){
                    temp.add(nums[i]);
                    res.add(new ArrayList<Integer>(temp));
                    temp.remove(temp.size()-1);
                } 
            }
            return;
        }
        if(k == 2){
            twoSum(res, temp, target, left, right, nums);
            return;
        }
        /*
        1. Key point on this function
        2. define the start and end point 
        3. k logical
        4. removed duplicated 
        5. add current num to list
        6. recurrisve: target - nums[i], k-1 from i to end
        7. remove current num because we need to arrage other permutation 
        */
        // k > 2 : choose nums[i] and do k-1 sum on the rest at right
        for (int i = left; i <= (right-k+1) ; i++) {
            // avoid duplicate
            if(i>left && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            kSum(res, temp, target - nums[i], k - 1, i + 1, right, nums);
            temp.remove(temp.size() - 1);
        }
        
    }
    
    private void twoSum(List<List<Integer>> res, List<Integer> temp, int target , int left, int right, int[] nums){
        while(left<right){
            if(nums[left]+nums[right] == target){
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size()-1);
                temp.remove(temp.size()-1);
                while(left<right && nums[left] == nums[left+1]) left++;
                while(left<right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
            }
            else if(nums[left]+nums[right] > target) right--;
            else left++;
        }
        return;
    }
}