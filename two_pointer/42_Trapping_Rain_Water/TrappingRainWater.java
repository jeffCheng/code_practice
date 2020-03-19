class Solution {
    /*
    1. Two Pointer
    2. from left and from right
    */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length -1;
        int maxLeftH = 0; //keep the height
        int maxRightH = 0; // keep the height
        int res = 0; //sum the reuslt
        
        while(left<right){
            if(height[left]>height[right]){
                maxRightH = Math.max(maxRightH, height[right]);
                res+= maxRightH - height[right];
                right--;
            }else{
                maxLeftH = Math.max(maxLeftH, height[left]);
                res+= maxLeftH - height[left];
                left++;
            }
        }
        return res ;
    }
}