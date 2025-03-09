class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0){
            return "";
        }
        HashMap<Character,Integer> tcount=new HashMap<>();
        HashMap<Character,Integer> windowCount=new HashMap<>();
        for(char c:t.toCharArray()){
            tcount.put(c,tcount.getOrDefault(c,0)+1);
        }
        int formed=0;
        int required=tcount.size();
        int l=0,r=0;
        int minLen=Integer.MAX_VALUE;
        int minLeft=0;
        while(r<s.length()){
            char c=s.charAt(r);
            windowCount.put(c,windowCount.getOrDefault(c,0)+1);
            if(tcount.containsKey(c) && windowCount.get(c).intValue()==tcount.get(c).intValue()){
                formed++;
            }
            while(required==formed){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    minLeft=l;
                }
                char leftMax=s.charAt(l);
                windowCount.put(leftMax,windowCount.get(leftMax)-1);
                if(tcount.containsKey(leftMax) && windowCount.get(leftMax)<tcount.get(leftMax)){
                    formed--;
                }
                l++;
            }
            r++;
        }
        return (minLen==Integer.MAX_VALUE)?"":s.substring(minLeft,minLeft+minLen);
    }
}