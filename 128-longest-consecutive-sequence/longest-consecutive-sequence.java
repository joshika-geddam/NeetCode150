class Solution {
    public int longestConsecutive(int[] nums) {
        int longest=0;
        HashMap<Integer,Boolean> map=new HashMap<>();
        int maxLen=0;
        for(int num:nums){
            map.put(num,false);
        }
        for(int num:nums){
            int current=1;
            int nextNum=num+1;
            while(map.containsKey(nextNum) && map.get(nextNum)==false){
                current++;
                map.put(nextNum,true);
                nextNum++;
            }
            int prevNum=num-1;
             while(map.containsKey(prevNum) && map.get(prevNum)==false){
                current++;
                map.put(prevNum,true);
                prevNum--;
            }
            maxLen=Math.max(maxLen,current);
        }
        return maxLen;
    }
}