class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visit=new boolean[n];
        if(dfs(source,destination,adj,visit)){
            return true;
        }
        return false;
    }
    public boolean dfs(int source,int destination,List<List<Integer>> adj,boolean[] visit){
        if(source==destination){
        return true;
        }
        visit[source]=true;
        for(int neighbor:adj.get(source)){
            if(!visit[neighbor]){
            if(dfs(neighbor,destination,adj,visit)){
                return true;
            }
        }
        }
        return false;
    }
}