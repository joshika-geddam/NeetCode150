class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int number=0;
        int curr='+';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                number=number*10+(c-'0');
            }
            if(!Character.isDigit(c) && c!=' ' ||i==s.length()-1){
                if(curr=='+'){
                    stack.push(number);
                }
                else if(curr=='-'){
                    stack.push(-number);
                }
                else if(curr=='*'){
                    stack.push(stack.pop() * number);
                }
                else if(curr=='/'){
                    stack.push(stack.pop() / number);
                }
                curr=c;
            number=0;
            }
            
        }
        int res=0;
        for(int num:stack){
            res+=num;
        }
        return res;
    }
}