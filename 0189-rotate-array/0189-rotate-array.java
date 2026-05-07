class Solution {

    public void reverse(int[]n,int start, int end){

      while(start<end){
        int temp= n[start];
        n[start]=n[end];
        n[end]=temp;
        start++;
        end--;
      }


    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}