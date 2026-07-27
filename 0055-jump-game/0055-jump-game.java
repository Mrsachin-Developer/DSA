class Solution {
    public boolean canJump(int[] nums) {
        int maxreach = 0;
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxreach) {
                return false;
            }
            reach = i + nums[i];
            maxreach = Math.max(maxreach, reach);

            if(maxreach>=nums.length-1){
            return true;
            }
        }
        return true;
    }
}