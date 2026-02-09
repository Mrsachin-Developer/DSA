// class Solution {
//     public int trap(int[] height) {
//         int n= height.length;

// int water=0;
//         for(int i=0;i<n;i++){
//          int left=i,right=i;

//                 int  lmax= height[i];
//                  int     rmax= height[i];
//             while(left>=0){
//                 if(height[left]>lmax){
//                     lmax=height[left];

//                 }
//                 left--;
//             }
//                while(right<n){

//                 if(height[right]>rmax){
//                     rmax=height[right];

//                 }
//                 right++;
//             }

//            int currentwater= Math.min(lmax,rmax)-height[i];

//            if(currentwater>=0){
//             water = water+currentwater;
//            }

//         }
//         return water;
//     }
// }

class Solution {
    public int trap(int[] height) {
        int lmax = 0;
        int rmax = 0;
        int left =0;
        int right = height.length - 1;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                lmax = Math.max(lmax, height[left]);
                water = water + lmax - height[left];
                left++;
            } else {
                rmax = Math.max(rmax, height[right]);
                water = water + rmax - height[right];
                right--;
            }

        }
        return water;
    }
}