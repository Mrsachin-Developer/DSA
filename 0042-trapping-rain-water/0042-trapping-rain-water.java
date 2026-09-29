// class Solution {

//     public int trap(int[] height) {

//         int n = height.length;

//         int[] prefixMax = new int[n];
//         int[] suffixMax = new int[n];

//         prefixMax[0] = height[0];

//         for (int i = 1; i < n; i++) {
//             prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
//         }

//         suffixMax[n - 1] = height[n - 1];

//         for (int i = n - 2; i >= 0; i--) {
//             suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
//         }

//         int water = 0;

//         for (int i = 0; i < n; i++) {
//             water += Math.min(prefixMax[i], suffixMax[i]) - height[i];
//         }

//         return water;
//     }
// }

class Solution {
    public int trap(int[] height) {
        int lmax = 0;
        int rmax = 0;
        int left = 0;
        int right = height.length - 1;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {

                if (lmax > height[left]) {
                    water = water + lmax - height[left];
                } else {
                    lmax = height[left];
                }
                left++;
            } else {
                if (rmax > height[right]) {

                    water = water + rmax - height[right];
                } else {
                    rmax = height[right];
                }
                right--;
            }

        }
        return water;
    }
}