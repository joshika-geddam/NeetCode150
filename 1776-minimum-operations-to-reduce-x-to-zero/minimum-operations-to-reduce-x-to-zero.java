class Solution {
    public int minOperations(int[] nums, int x) {
        int l=0,r=0;
        int sum=0;
        int totalSum=Arrays.stream(nums).sum();
        int minLen=-1;
        int target=totalSum-x;
        if(target<0){
            return -1;
        }
        while(r<nums.length){
            sum=sum+nums[r];
            while(sum>target && l<=r){
                sum=sum-nums[l];
                l++;
            }
            if(sum==target){
            minLen=Math.max(minLen,r-l+1);
            }
            r++;
        }
        if(minLen==-1){
            return -1;
        }
        return nums.length-minLen; 
    }
}