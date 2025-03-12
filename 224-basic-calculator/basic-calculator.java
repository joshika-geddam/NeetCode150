class Solution {
    public int calculate(String s) {
        int result=0;
        int number=0;
        int signValue=1;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                number=number*10+(c-'0');
            }
            if(c=='+'||c=='-'){
                result+=number*signValue;
                signValue=(c=='-')?-1:1;
                number=0;
            }
            else if(c=='('){
                stack.push(result);
                stack.push(signValue);
                result=0;
                signValue=1;
            }
            else if(c==')'){
                result+=number*signValue;
                result*=stack.pop();
                result+=stack.pop();
                number=0;
            }
        }
        return result+number*signValue;

        
    }
}