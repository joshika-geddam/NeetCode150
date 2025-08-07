class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(res,0,0,n,"");
        return res;
    }
    public void backtrack(List<String> res,int open,int close,int max,String curr){
        if(curr.length()==2*max){
            res.add(curr);
        }
        if(open<max){
            backtrack(res,open+1,close,max,curr+"(");
        }
        if(close<open){
            backtrack(res,open,close+1,max,curr+")");
        }
    }
}