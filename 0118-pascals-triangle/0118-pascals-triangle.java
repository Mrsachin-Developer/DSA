class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for(int row = 0; row < numRows; row++) {

            List<Integer> curr = new ArrayList<>();

            long ans = 1;

            for(int col = 0; col <= row; col++) {

                curr.add((int)ans);

                ans = ans * (row - col);
                ans = ans / (col + 1);
            }

            result.add(curr);
        }

        return result;
    }
}