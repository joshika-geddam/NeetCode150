class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int pair[]:prerequisites){
            map.computeIfAbsent(pair[0],k->new ArrayList<>()).add(pair[1]);
        }
        List<Integer> output=new ArrayList<>();
        HashSet<Integer> cycle=new HashSet<>();
        HashSet<Integer> visit=new HashSet<>();
        for(int course=0;course<numCourses;course++){
            if(!dfs(course,map,cycle,visit,output)){
                return new int[0];
            }
        }
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=output.get(i);
        }
        return result;   
    }
    public boolean dfs(int course,HashMap<Integer,List<Integer>> map,HashSet<Integer> cycle,HashSet<Integer> visit,List<Integer> output){
        if(cycle.contains(course)){
            return false;
        }
        if(visit.contains(course)){
            return true;
        }
        cycle.add(course);
        for(int pre:map.getOrDefault(course,Collections.emptyList())){
            if(!dfs(pre,map,cycle,visit,output)){
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}