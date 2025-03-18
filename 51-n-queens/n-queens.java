class Solution {
    HashSet<Integer> col=new HashSet<>();
    HashSet<Integer> pos=new HashSet<>();
    HashSet<Integer> neg=new HashSet<>();
    List<List<String>> res =new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] r:board){
            Arrays.fill(r,'.');
        }
        backtrack(0,n,board);
        return res;
    }
    public void backtrack(int r,int n,char[][] board){
        if(r==n){
            List<String> copy=new ArrayList<>();
            for(char[] row:board){
                copy.add(new String(row));
            }
            res.add(copy);
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
            backtrack(r+1,n,board);
            col.remove(c);
            pos.remove(r+c);
            neg.remove(r-c);
            board[r][c]='.';
        }
    }
}