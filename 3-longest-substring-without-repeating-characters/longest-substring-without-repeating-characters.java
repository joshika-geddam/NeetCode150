class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list=new ArrayList<>();
        int start=0;
        int end=0;
        int maxLen=0;
        while(end<s.length()){
            if(!list.contains(s.charAt(end))){
                list.add(s.charAt(end));
                maxLen=Math.max(list.size(),maxLen);
                end++;
            }
            else{
                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return maxLen;
        
    }
}