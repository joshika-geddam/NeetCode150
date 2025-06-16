class Solution {
    public boolean canJump(int[] nums) {
        int prev=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=prev){
                prev=i;
            }
        }
        return prev==0;
        
    }
}