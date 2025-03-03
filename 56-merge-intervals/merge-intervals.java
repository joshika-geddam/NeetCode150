class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] prev=intervals[0];
        List<int[]> list=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            int[] interval=intervals[i];
            if(interval[0]<=prev[1]){
                prev[1]=Math.max(interval[1],prev[1]);
            }
            else{
                list.add(prev);
                prev=interval;
            }
        }
        list.add(prev);
        return list.toArray(new int[list.size()][]);
        
    }
}