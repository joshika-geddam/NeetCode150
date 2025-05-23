class Solution {
     List<List<String>> result=new ArrayList<>();
     HashSet<Integer> col=new HashSet<>();
     HashSet<Integer> pos=new HashSet<>();
     HashSet<Integer> neg=new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        backtrack(0,board,n);
        return result;  
    }
    public void backtrack(int r,char[][] board,int n){
        if(r==n){
            List<String> copy=new ArrayList<>();
            for(char[] row:board){
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }
        for(int c=0;c<n;c++){
            if(col.contains(c)||pos.contains(r+c)||neg.contains(r-c)){
                continue;
            }
            col.add(c);
            pos.add(r+c);
            neg.add(r-c);
                        board[r][c]='Q';

            backtrack(r+1,board,n);
            col.remove(c);
            pos.remove(r+c);
            neg.remove(r-c);
            board[r][c]='.';
        }
    }
}