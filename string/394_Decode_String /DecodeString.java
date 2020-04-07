class Solution {
    int idx = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        while(idx<s.length()){
            char c = s.charAt(idx++);
            if('0'<=c && c<='9'){
                counter= 10*counter + c-'0';
            }else if(c =='['){
                String sub = decodeString(s);
                for(int i=0;i<counter;i++){
                    sb.append(sub);
                }
                counter = 0;
            }else if(c == ']'){
                return sb.toString();
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}