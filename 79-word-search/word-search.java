class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(word.charAt(0)==board[i][j] && search(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(int i,int j,int index,char[][] board,String word){
        if(index==word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||word.charAt(index)!=board[i][j]||visited[i][j]){
            return false;
        }
        visited[i][j]=true;
        if(search(i+1,j,index+1,board,word)||
            search(i-1,j,index+1,board,word)||
            search(i,j+1,index+1,board,word)||
            search(i,j-1,index+1,board,word)){
                return true;
            }
            visited[i][j]=false;
            return false;
    }
}