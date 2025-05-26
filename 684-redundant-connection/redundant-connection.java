class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[] visit=new boolean[n+1];
            if(dfs(u,-1,adj,visit)){
                return edge;
            }
        }
        return new int[]{};
    }
    public boolean dfs(int node,int parent,List<List<Integer>> adj, boolean[] visit){
        if(visit[node]){
            return true;
        }
        visit[node]=true;
        for(int neighbor:adj.get(node)){
            if(neighbor==parent){
                continue;
            }
            if(dfs(neighbor,node,adj,visit)){
                return true;
            }
        }
        return false;
    }

}