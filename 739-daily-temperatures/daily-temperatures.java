class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[n];
        for(int i=temperatures.length-1;i>-1;i--){
            while(!stack.isEmpty()&&temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }
}