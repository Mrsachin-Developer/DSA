class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            String op = operations[i];

            if (op.equals("C") || op.equals("D") || op.equals("+")) {

                if (op.equals("C")) {
                    st.pop();
                }
                if (op.equals("D")) {
                    int val = st.peek();
                    st.push(2 * val);

                }
                if (op.equals("+")) {
                    // int first = st.pop();
                    // int second = st.pop();
                    int size = st.size();
                    int first = st.get(size - 1);
                    int second = st.get(size - 2);
                    int sum = first + second;
                
                    st.push(sum);
                }
            } else {

                int num = Integer.parseInt(op);
                st.push(num);
            }

        }

        int totalSum = 0;
        while (!st.isEmpty()) {
            totalSum += st.pop();
        }

        return totalSum;
    }
}