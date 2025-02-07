class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0){
            return 0;
        }
        int i=0;
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();
        while(i<heights.length){
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()]){
                stack.push(i++);
            }
            else{
                int top=stack.pop();
                int area=heights[top]*(stack.isEmpty()?i:i-stack.peek()-1);
                maxArea=Math.max(maxArea,area);
            }
        }
        while(!stack.isEmpty()){
            int top=stack.pop();
            int area=heights[top]*(stack.isEmpty()?i:i-stack.peek()-1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
        
    }
}
