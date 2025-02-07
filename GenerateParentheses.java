class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(result,n,0,0,"");
        return result;
    }
    public void backtrack(List<String> result,int max,int open,int close,
    String current){
        if(current.length()==2*max){
            result.add(current);
            return;
        }
        if(open<max){
            backtrack(result,max,open+1,close,current+"(");
        }
        if(close<open){
            backtrack(result,max,open,close+1,current+")");
        }
    }
}
