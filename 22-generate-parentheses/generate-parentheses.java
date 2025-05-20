class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(result,0,0,"",n);
        return result;
    }
    public void backtrack(List<String> result,int open,int close,String current,int max){
        if(current.length()==2*max){
            result.add(current);
            return;
        }
        if(open<max){
            backtrack(result,open+1,close,current+"(",max);
        }
        if(close<open){
            backtrack(result,open,close+1,current+")",max);
        }
    }
}