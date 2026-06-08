class Solution {
    public int[] dailyTemperatures(int[] a) {
         class Node{
            int val;
            int idx;

            Node(int val, int idx){
                this.val = val;
                this.idx = idx;
            }
        }
         int n = a.length;
         Deque<Node> st = new ArrayDeque<>();
         int[] res = new int[n];

        res[n-1] = 0;
        st.push(new Node(a[n-1], n-1));

        for(int i=n-2; i>=0; i--){
            while(!st.isEmpty() && st.peek().val <= a[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i] = 0;
            else res[i] = st.peek().idx - i;

            st.push(new Node(a[i], i));
        }
        return res;
    }
}
