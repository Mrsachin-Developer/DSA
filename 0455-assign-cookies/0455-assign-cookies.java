class Solution {
    public int findContentChildren(int[] g, int[] s) {
Arrays.sort(g);
Arrays.sort(s);
        int lg = g.length;
        int ls = s.length;
        int child = 0;
        int cookies = 0;
        while (child < lg && cookies < ls) {
            if (s[cookies] >= g[child]) {
                child++;
            }
            cookies++;
        }
        return child;
    }
}