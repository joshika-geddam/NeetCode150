class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        List<List<Integer>> result=new ArrayList<>();
        int row=height.length;
        int col=height[0].length;
        boolean[][] pacific=new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];
        for(int r=0;r<row;r++){
            dfs(r,0,height,pacific);
            dfs(r,col-1,height,atlantic);
        }
        for(int c=0;c<col;c++){
            dfs(0,c,height,pacific);
            dfs(row-1,c,height,atlantic);
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
    public void dfs(int row,int col,int[][] height,boolean[][] visit){
        visit[row][col]=true;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:directions){
            int newR=row+dir[0];
            int newC=col+dir[1];
            while(newR>=0 && newR<height.length && newC>=0 && newC<height[0].length &&
            height[newR][newC]>=height[row][col] && !visit[newR][newC]){
                dfs(newR,newC,height,visit);
            }
        }
    }
}