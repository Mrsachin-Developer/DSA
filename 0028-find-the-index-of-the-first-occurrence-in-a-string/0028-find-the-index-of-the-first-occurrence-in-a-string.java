class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        if (n == 0) return 0;

        int i = 0;     // haystack pointer
        int j = 0;     // needle pointer
        int start = 0;

        while (i < h) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == n) {
                    return start;
                }
            } else {
                start++;
                i = start;
                j = 0;
            }

            // early stop if remaining chars are less than needle
            if (start > h - n) break;
        }
        return -1;
    }
}