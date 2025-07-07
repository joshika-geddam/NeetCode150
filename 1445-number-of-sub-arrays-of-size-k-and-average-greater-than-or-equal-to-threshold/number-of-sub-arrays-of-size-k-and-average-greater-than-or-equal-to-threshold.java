class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int l=0;
        int r=0;
        int sum=0;
        int count=0;
        while(r<nums.length){
            sum=sum+nums[r];
            if(r-l+1==k){
                if(sum/k>=threshold){
                    count++;
                }
                sum=sum-nums[l];
                l++;
            }
            r++;
        }
        return count;
        
    }
}