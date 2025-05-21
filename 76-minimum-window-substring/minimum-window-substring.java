class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0||s.length()==0){
            return "";
        }
        HashMap<Character,Integer> windowCount=new HashMap<>();
        HashMap<Character,Integer> tcount=new HashMap<>();
        for(char c:t.toCharArray()){
            tcount.put(c,tcount.getOrDefault(c,0)+1);
        }
        int required=tcount.size();
        int formed=0;
        int left=0;
        int right=0;
        int minLen=Integer.MAX_VALUE;
        int minLeft=0;
        while(right<s.length()){
            char c=s.charAt(right);
            windowCount.put(c,windowCount.getOrDefault(c,0)+1);
            if(tcount.containsKey(c)&&windowCount.get(c).intValue()==tcount.get(c).intValue()){
                formed++;
            }
            while(required==formed){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    minLeft=left;
                }
                char leftMax=s.charAt(left);
                windowCount.put(leftMax,windowCount.get(leftMax)-1);
                if(tcount.containsKey(leftMax) && windowCount.get(leftMax)<tcount.get(leftMax)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return (minLen==Integer.MAX_VALUE)?"":s.substring(minLeft,minLeft+minLen);
    }
}