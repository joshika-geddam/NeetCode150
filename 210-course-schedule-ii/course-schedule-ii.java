class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int[] pair:prerequisites){
            map.computeIfAbsent(pair[0],k->new ArrayList<>()).add(pair[1]);
        }
        HashSet<Integer> cycle=new HashSet<>();
        HashSet<Integer> visit=new HashSet<>();
        List<Integer> output=new ArrayList<>();
        for(int course=0;course<numCourses;course++){
            if(!dfs(course,cycle,visit,output,map)){
                return new int[0];
            }
        }
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=output.get(i);
        }
        return result;
    }
    public boolean dfs(int course,HashSet<Integer> cycle,HashSet<Integer> visit, List<Integer> output,HashMap<Integer,List<Integer>> map){
        if(cycle.contains(course)){
            return false;
        }
        if(visit.contains(course)){
            return true;
        }
        cycle.add(course);
        for(int pre:map.getOrDefault(course,Collections.emptyList())){
            if(!dfs(pre,cycle,visit,output,map)){
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}