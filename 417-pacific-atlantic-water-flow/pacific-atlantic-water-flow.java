class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result=new ArrayList<>();
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] pacific=new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];
        for(int r=0;r<row;r++){
            dfs(r,0,heights,pacific);
            dfs(r,col-1,heights,atlantic);
        }
        for(int c=0;c<col;c++){
            dfs(0,c,heights,pacific);
            dfs(row-1,c,heights,atlantic);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    public void dfs(int row,int col,int[][] heights,boolean[][] visit){
        visit[row][col]=true;
        int directions[][] ={{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] dir:directions){
            int newR=row+dir[0];
            int newC=col+dir[1];
            while(newR>=0 && newR<heights.length && newC>=0 && newC<heights[0].length &&
            heights[newR][newC]>=heights[row][col] && !visit[newR][newC]){
                dfs(newR,newC,heights,visit);
            }
        }
    }
}