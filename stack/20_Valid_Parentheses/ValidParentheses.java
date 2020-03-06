class Solution {
    /*
    Time: 21:46 -> 23:00
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            //System.out.println(c);
            if(c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.size() == 0 || stack.pop()!=c) return false;
            i++;
        }
        return stack.size() == 0;
    }
}