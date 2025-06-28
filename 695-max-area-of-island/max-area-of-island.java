class Solution {
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        visited=new boolean[row][col];
        int maxArea=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                maxArea=Math.max(maxArea,area(i,j,grid));
                }
            }
        }
        return maxArea;  
    }
    public int area(int i,int j,int[][] grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0|| visited[i][j]){
            return 0;
        }
        grid[i][j]=1;
        visited[i][j]=true;
        return 1+(area(i+1,j,grid)+area(i-1,j,grid)+area(i,j+1,grid)+area(i,j-1,grid));
    }
}