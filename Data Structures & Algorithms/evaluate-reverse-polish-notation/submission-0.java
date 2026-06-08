class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int two = deque.pop();
                int one = deque.pop();
                int next = one + two;
                deque.push(next);
            } else if (token.equals("-")) {
                int two = deque.pop();
                int one = deque.pop();
                int next = one - two;
                deque.push(next);
            } else if (token.equals("*")) {
                int two = deque.pop();
                int one = deque.pop();
                int next = one * two;
                deque.push(next);
            } else if (token.equals("/")) {
                int two = deque.pop();
                int one = deque.pop();
                int next = one / two;
                deque.push(next);
            } else {
                deque.push(Integer.parseInt(token));
            }
        }
        return deque.peek();
    }
}