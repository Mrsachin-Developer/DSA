class StockSpanner {
    private Stack<int[]> st;   // stack will store [price, index]
    private int index;         // keep track of the current day index
    
    public StockSpanner() {
        st = new Stack<>();
        index = -1;  // before first price
    }
    
    public int next(int price) {
        index++; 
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        int prevIndex = st.isEmpty() ? -1 : st.peek()[1];
        int ans = index - prevIndex;


        st.push(new int[]{price, index});

        return ans;
    }
}
