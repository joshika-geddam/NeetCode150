class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int minutes=0;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean rot=false;
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int r=curr[0];
                int c=curr[1];
                for(int[] dir:directions){
                    int newR=r+dir[0];
                    int newC=c+dir[1];
                    while(newR>=0 && newR<row && newC>=0 && newC<col &&
                    grid[newR][newC]==1){
                        grid[newR][newC]=2;
                        queue.add(new int[]{newR,newC});
                        fresh--;
                        rot=true;
                    }
                }
            }
            if(rot){
                minutes++;
            }
        }
        return (fresh==0)?minutes:-1;
        
    }
}