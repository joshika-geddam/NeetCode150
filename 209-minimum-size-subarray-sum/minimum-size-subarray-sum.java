class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,sum=0,minLen=Integer.MAX_VALUE;
        while(r<nums.length){
            sum=sum+nums[r];
            while(sum>=target){
                minLen=Math.min(minLen,r-l+1);
                sum=sum-nums[l];
                l++;
            }
            r++;
        }
        if(minLen==Integer.MAX_VALUE){
            return 0;
        }
        return minLen;
    }
}