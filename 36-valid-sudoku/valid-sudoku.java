class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c=board[i][j];
                if(c!='.'){
                    if(!set.add(c+"is presnt in a row"+i)||
                    !set.add(c+"is present in a col"+j)||
                    !set.add(c+"is present in a box"+i/3+'-'+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}