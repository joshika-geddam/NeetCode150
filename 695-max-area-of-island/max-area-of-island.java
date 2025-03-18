class Solution {
    boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        int rows=grid.length;
        int col=grid[0].length;
        seen=new boolean[rows][col];
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                maxArea=Math.max(maxArea,area(i,j,grid));
            }
        }
        return maxArea;
    }
    public int area(int i,int j,int[][] grid){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||seen[i][j]||grid[i][j]==0){
            return 0;
        }
        seen[i][j]=true;
        return(1+area(i+1,j,grid)+area(i-1,j,grid)+area(i,j+1,grid)+area(i,j-1,grid));
    }
}