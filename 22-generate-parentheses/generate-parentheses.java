class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(result,0,0,"",n);
        return result;
    }
    public void backtrack(List<String> res,int open,int close,String current,int max){
        if(current.length()==2*max){
            res.add(current);
            return;
        }
        if(open<max){
            backtrack(res,open+1,close,current+"(",max);
        }
        if(close<open){
            backtrack(res,open,close+1,current+")",max);
        }
    }
}