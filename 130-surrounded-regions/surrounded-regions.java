class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        for(int r=0;r<row;r++){
            if(board[r][0]=='O'){
                dfs(board,r,0);
            }
            if(board[r][col-1]=='O'){
                dfs(board,r,col-1);
            }
        }
        for(int c=0;c<col;c++){
            if(board[0][c]=='O'){
                dfs(board,0,c);
            }
            if(board[row-1][c]=='O'){
                dfs(board,row-1,c);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!='O'){
            return;
        }
        board[i][j]='T';
        dfs(board,i+1,j);  
        dfs(board,i-1,j);  
        dfs(board,i,j+1);
        dfs(board,i,j-1);     
        }
}