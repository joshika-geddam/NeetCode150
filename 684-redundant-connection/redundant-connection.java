class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[] visit=new boolean[n+1];
            if(dfs(u,-1,visit,adj)){
                return edge;
            }
        }
        return new int[0];
    }
    public boolean dfs(int node,int parent,boolean[] visit,List<List<Integer>> adj){
        if(visit[node]){
            return true;
        }
        visit[node]=true;
        for(int neighbor:adj.get(node)){
            if(neighbor==parent){
                continue;
            }
            if(dfs(neighbor,node,visit,adj)){
                return true;
            }
        }
        return false;
    }
}