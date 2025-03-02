class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int removeCount=0;
        int prev=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prev){
                removeCount++;
            }
            else{
                prev=intervals[i][1];
            }
        }
        return removeCount;
    }
}