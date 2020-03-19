class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int res =0;
        int fast = 0;
        int slow = 0;
        
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            res = Math.max(slow, fast-slow+1);
            map.put(c, ++fast);
        }
        return res;
    }
    
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int res =0;
        int fast = 0;
        int slow = -1;
        
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            res = Math.max(slow, fast-slow);
            map.put(c, fast++);
        }
        return res;
    }
}