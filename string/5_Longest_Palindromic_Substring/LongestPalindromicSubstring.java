class Solution {
    /*
    Find the longest one
    */
    int left;
    int right;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        left = 0;
        right = 0;
        for(int i=0;i<s.length();i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return s.substring(left+1, left+ right+1);
    }
    
    private void helper(String s, int start , int end){
        while(start>=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(right<end-start){
            left = start;
            right = end- start-1;
        }
    }
}