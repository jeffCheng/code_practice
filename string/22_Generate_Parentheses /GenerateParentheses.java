class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, 0, 0 , res, "");
        return res;
    }
    
    private void helper(int n, int open , int close , List<String> res , String s){
        if(n*2 == s.length()){
            res.add(s);
            return;
        }
        if(open<n) helper(n, open+1, close, res, s+"(");
        if(close<open) helper(n, open, close+1,res , s+")");
        return;
    }
}