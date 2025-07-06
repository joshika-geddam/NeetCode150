class Solution {
    boolean[][] visited;
    int originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row=image.length;
        int col=image[0].length;
        visited=new boolean[row][col];
        originalColor=image[sr][sc];
                if(image[sr][sc]==originalColor){
                    dfs(sr,sc,image,color);
                }
        return image;
    }
    public void dfs(int i,int j,int[][] image,int color){
    
        if(i<0||j<0||i>=image.length||j>=image[0].length||image[i][j]!=originalColor||visited[i][j]){
            return;
        }
            visited[i][j]=true;
        image[i][j]=color;
        dfs(i+1,j,image,color);
        dfs(i-1,j,image,color);
        dfs(i,j+1,image,color);
        dfs(i,j-1,image,color);
    }
}