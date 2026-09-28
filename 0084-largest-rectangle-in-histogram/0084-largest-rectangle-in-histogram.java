class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st=new Stack();

        int n=heights.length;
           int maxArea=0;

        for(int i=0;i<=n-1;i++){
            // NEXT SMALLEST ELEMENT
            while(!st.isEmpty()&& heights[st.peek()]>heights[i]){
                int element=st.peek();
                st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
             maxArea=Math.max(maxArea,heights[element]*(nse-pse-1));

            }
            st.push(i);

        }
        // PREVIOUS SMALLEST ELEMENT
        while(!st.isEmpty()){
            int nse=n;
            int element=st.peek();
            st.pop();
            int pse=st.empty()?-1:st.peek();
   
             maxArea=Math.max(maxArea,heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
}