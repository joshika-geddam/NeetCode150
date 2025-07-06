class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visit=new boolean[n+1];
        int count=0;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                adj.get(i).add(j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                count++;
                dfs(i,adj,visit);
            }
        }
        return count;   
    }
    public void dfs(int i,List<List<Integer>> adj,boolean[] visit){
        visit[i]=true;
        for(int neighbor:adj.get(i)){
            if(!visit[neighbor]){
                dfs(neighbor,adj,visit);
            }
        }
    }
}