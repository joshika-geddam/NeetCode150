class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int left=height[l];
        int right=height[r];
        int res=0;
        while(l<r){
            if(left<right){
                l++;
                left=Math.max(height[l],left);
                res+=left-height[l];
            }
            else{
                r--;
                right=Math.max(height[r],right);
                res+=right-height[r];
            }
        }
        return res;
    }
}