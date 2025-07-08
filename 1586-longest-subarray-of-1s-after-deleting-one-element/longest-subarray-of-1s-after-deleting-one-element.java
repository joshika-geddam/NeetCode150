class Solution {
    public int longestSubarray(int[] nums) {
        int l=0,r=0,maxLen=0,count=1;
        while(r<nums.length){
            if(nums[r]==0){
                count--;
            }
            if(count<0){
                if(nums[l]==0){
                    count++;
                }
                l++;
            }
            maxLen=Math.max(maxLen,r-l);
            r++;
        }
        return maxLen;
    }
}