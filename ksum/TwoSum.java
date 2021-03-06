class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])) return new int[]{map.get(target-nums[i]), i};
            else map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}

//2021/01/11
/*
It is the wrong solution regarding I need to ignore the current number. 
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length-1;i++) map.put(nums[i], i);
        
        for(int i=1;i<nums.length;i++){
            if(map.containsKey(target - nums[i] )) return new int[]{i , map.get(target - nums[i])};
        }
        return  new int[]{-1,-1};
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i] )) return new int[]{i , map.get(target - nums[i])};
            else map.put(nums[i], i);
        }
        return  new int[]{-1,-1};
    }
}
