class Solution {
    public int largestRectangleArea(int[] a) {

        int n = a.length;

        Deque<Node> st = new ArrayDeque<>();
        st.push(new Node(0, a[0]));

        int max = 0;

        for(int i=1; i<n; i++){
            int curr = a[i];
            int index = i;
            while(!st.isEmpty() && st.peek().ele > curr){
                index = st.peek().idx;
                max = Math.max(max, st.peek().ele * (i - index)); 
                st.pop();
            }
            st.push(new Node(index, curr));
        }

        while(!st.isEmpty()){
            int h = st.peek().ele;
            int b = n - st.peek().idx;
            max = Math.max(max, h * b);
            st.pop();
        }
        return max;
    }
}

class Node{
            int idx;
            int ele;

            Node(int idx, int ele){
            this.idx = idx;
            this.ele = ele;
            }
        }