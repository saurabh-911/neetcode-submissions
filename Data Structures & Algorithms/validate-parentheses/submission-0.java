class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // 1. If it's an opening bracket, push to stack
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } 
            // 2. If it's a closing bracket, validate and pop
            else {
                // If stack is empty before matching, it's invalid
                if (st.isEmpty()) return false;
                
                char top = st.peek();
                if ((ch == '}' && top == '{') ||  (ch == ')' && top == '(') || (ch == ']' && top == '[')) {
                    st.pop();
                } else {
                    return false; // Mismatched brackets
                }
            }
        }
        
        // If stack is empty, all brackets were matched correctly
        return st.isEmpty();
    }
}


