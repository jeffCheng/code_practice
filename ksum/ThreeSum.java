class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            if(i== 0 || (i>0 &&nums[i] != nums[i-1])){ //we can simply put as if(i==0 ||nums[i]!= nums[i-1])
                int left = i+1;
                int right = nums.length -1;
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
                        while(left<right && nums[left] == nums[left+1]) left++;
                        left++;
                    }else if(nums[left]+nums[right] > sum){
                        while(left<right && nums[right] == nums[right-1]) right--;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}