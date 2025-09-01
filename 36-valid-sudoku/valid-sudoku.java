class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char ch=board[i][j];
                if(ch!='.'){
                    if(!set.add(ch+"is present in a row"+i)||
                    !set.add(ch+"is present in a col"+j)||
                    !set.add(ch+"is present in a box"+i/3+'-'+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
}