class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left=0;
        int right=0;
        int maxOccur=s1.length();
        int[] freq=new int[26];
        for(char c:s1.toCharArray()){
            freq[c-'a']++;
        }
        while(right<s2.length()){
            if(freq[s2.charAt(right++)-'a']-->0){
                maxOccur--;
            }
            if(maxOccur==0){
                return true;
            }
            else if(right-left==s1.length() && freq[s2.charAt(left++)-'a']++>=0){
                maxOccur++;
            }
        }
        return false;
    }
}