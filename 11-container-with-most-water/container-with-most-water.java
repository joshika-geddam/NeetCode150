class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        int maxArea=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(area,maxArea);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}