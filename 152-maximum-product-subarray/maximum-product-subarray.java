class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int n=nums.length;
        int left=1;
        int right=1;
        int maxLen=nums[0];
        for(int i=0;i<nums.length;i++){
            left=(left==0)?1:left;
            right=(right==0)?1:right;
            left*=nums[i];
            right*=nums[n-1-i];
            maxLen=Math.max(maxLen,Math.max(left,right));
        }
        return maxLen;
        
    }
}