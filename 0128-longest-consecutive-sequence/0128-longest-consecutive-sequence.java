// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int n =nums.length;

//         if(n==0){
//             return 0;
//         }
//         int longest=1;
//               Set<Integer> set = new HashSet<>();
//               for(int i=0;i<n;i++){
//                 set.add(nums[i]);
//               }

//         for(int element:set){
//             //it means this is the startin point and start iterating from here 
//             if(!set.contains(element-1)){
//                 int count =1;
//                 int x=element;
//                 while(set.contains(x+1)){
//                     x=x+1;
//                     count=count+1;
//                 }
//             longest = Math.max(longest, count);

//             }
//         }
//         return longest;

//     }
// }

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int longestLength = 0;

        for (int num : set) {
            if (!set.contains(num-1)) {
                int currentnum = num;
                int currentLength = 1;

                while (set.contains(currentnum + 1)) {
                    currentnum++;
                    currentLength++;
                }
                longestLength = Math.max(currentLength, longestLength);
            }
        }

        return longestLength;
    }
}