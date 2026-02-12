class Solution {
    public boolean isPalindrome(String s) {
        String pure = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int left = 0;
        int right = pure.length() - 1;
        while (left < right) {
            if (pure.isEmpty()) 
                return true;
            
            if (pure.charAt(left) == pure.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}