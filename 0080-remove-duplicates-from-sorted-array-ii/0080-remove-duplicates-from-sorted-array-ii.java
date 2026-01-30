class Solution {
    public int removeDuplicates(int[] nums) {
        int i=2;
        int j=2;
        int n=nums.length;
        for(j=2;j<n;j++){
if(nums[j]!=nums[i-2]){
    nums[i]=nums[j];
    i++;
}

        }
        return i;
    }
}