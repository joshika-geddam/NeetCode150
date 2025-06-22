class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        int i=0;
        int left=0;
        int right=heights.length-1;
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        while(i<heights.length){
            if(stack.isEmpty()||heights[i]>=heights[stack.peek()]){
                stack.push(i++);
            }
            else{
                int top=stack.pop();
            int area=heights[top]*(stack.isEmpty()?i:i-stack.peek()-1);
            maxArea=Math.max(area,maxArea);
            }
            
        }
        while(!stack.isEmpty()){
            int top=stack.pop();
            int area=heights[top]*(stack.isEmpty()?i:i-stack.peek()-1);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}