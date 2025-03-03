class Solution {
    public int maxSubArray(int[] nums) {
        int max_Array=nums[0];
        int curr_max=nums[0];
        for(int i=1;i<nums.length;i++){
            curr_max=Math.max(nums[i],curr_max+nums[i]);
            max_Array=Math.max(curr_max,max_Array);
        }
        return max_Array;
    }
}