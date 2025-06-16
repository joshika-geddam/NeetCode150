class Solution {
    public int maxSubArray(int[] nums) {
        int current=nums[0];
        int maxLen=nums[0];
        for(int i=1;i<nums.length;i++){
            current=Math.max(nums[i],current+nums[i]);
            maxLen=Math.max(maxLen,current);
        }
        return maxLen;
        
    }
}