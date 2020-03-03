class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            if(i== 0 || nums[i] != nums[i-1]){
                for(int j=i+1;j<nums.length-2;j++){
                    if(j== i+1 || nums[j] != nums[j-1]){
                        int left = j+1;
                        int right = nums.length -1;
                        int sum = target - nums[j]-nums[i];
                        while(left<right){
                            if(nums[left]+nums[right] == sum){
                                List<Integer> temp = new ArrayList<Integer>();
                                temp.add(nums[i]);
                                temp.add(nums[j]);
                                temp.add(nums[left]);
                                temp.add(nums[right]);
                                res.add(temp);
                                while(left<right && nums[left] == nums[left+1]) left++;
                                while(left<right && nums[right] == nums[right-1]) right--;
                                left++;
                                right--;
                            }else if(nums[left]+nums[right] < sum){
                                left++;
                            }else {
                                right--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}