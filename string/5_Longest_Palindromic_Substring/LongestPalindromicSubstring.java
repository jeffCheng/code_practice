class Solution {
    /*
    Find the longest one
    */
    int left;
    int maxLen;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        left = 0;
        maxLen = 0;
        for(int i=0;i<s.length();i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return s.substring(left,left+maxLen);
    }
    
    private void helper(String s, int start , int end){
        while(start>=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(maxLen<end-start){
            left = start+1; //because while loop will be start index < 0 (start--)
            maxLen = end - left; // end - start -1;
        }
    }
}