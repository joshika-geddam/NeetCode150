class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] ans=new int[n];
        left[0]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        right[n-1]=1;
        for(int i=n-2;i>-1;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;
    }
}  
