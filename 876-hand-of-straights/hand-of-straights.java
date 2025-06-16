class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        while(!map.isEmpty()){
            int start=map.firstKey();
            int count=map.get(start);
            for(int i=0;i<groupSize;i++){
                int currentIndex=i+start;
                if(map.getOrDefault(currentIndex,0)<count){
                    return false;
                }
                map.put(currentIndex,map.get(currentIndex)-count);
                if(map.get(currentIndex)==0){
                    map.remove(currentIndex);
                }
            }
        }
        return true;
        
    }
}