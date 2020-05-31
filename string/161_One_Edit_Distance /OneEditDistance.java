//161. One Edit Distance
class Solution {
    
    //only one step: insert/delete/replace
    public boolean isOneEditDistance(String s, String t) {
        
        if(s.length() == 0 && t.length() == 0) return false;
        
        int m = s.length();
        int n = t.length();
        
        if(Math.abs(m-n)>1) return false; // That will not be happened. 
        
        //two pointers
        int i = 0;
        int j = 0;
        int count = 0;
        
        while(i < m && j < n ){
            if(s.charAt(i) == t.charAt(j)){
                 i++;j++;
            }else {
                count++;
                if(count >1) return false;
                else if(m>n) i++;
                else if(n>m) j++;
                else{ i++;j++;}
            }
        }
        if(i<m || j<n) count++;
        if(count == 1) return true;
        return false;
    }
}