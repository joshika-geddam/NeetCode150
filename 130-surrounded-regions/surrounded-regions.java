class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        for(int r=0;r<row;r++){
            if(board[r][0]=='O'){
                dfs(r,0,board);
            }
            if(board[r][col-1]=='O'){
                dfs(r,col-1,board);
            }
        }
        for(int c=0;c<col;c++){
            if(board[0][c]=='O'){
                dfs(0,c,board);
            }
            if(board[row-1][c]=='O'){
                dfs(row-1,c,board);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] board){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!='O'){
            return;
        }
        board[i][j]='T';
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }

}