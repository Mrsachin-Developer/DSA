class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {

            int current = m.get(s.charAt(i));

            if (i + 1 < n && current < m.get(s.charAt(i + 1))) {
                sum = sum - current;
            }
            else{

            sum = sum + current;
            }
        }
        return sum;

    }
}