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
                int current=i+start;
                if(map.getOrDefault(current,0)<count){
                    return false;
                }
                map.put(current,map.get(current)-count);
                if(map.get(current)==0){
                    map.remove(current);
                }

            }
        }
        return true;
    }
}