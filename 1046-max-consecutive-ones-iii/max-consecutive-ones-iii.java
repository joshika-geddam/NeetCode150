class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int count=k;
        int maxLen=0;
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
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}