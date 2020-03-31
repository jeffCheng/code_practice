class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chrs = str.toCharArray();
            Arrays.sort(chrs);
            if(map.containsKey(new String(chrs))){
                map.get(new String(chrs)).add(str);
            }else{
                List<String> temp = new ArrayList<String>();
                temp.add(str);
                 map.put(new String(chrs),temp);
            }
        }
        return new ArrayList(map.values());
    }
}