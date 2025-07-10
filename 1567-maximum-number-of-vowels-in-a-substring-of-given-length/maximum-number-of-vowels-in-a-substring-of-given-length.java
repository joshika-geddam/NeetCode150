class Solution {
    public int maxVowels(String s, int k) {
        int l=0;
        int count=0;
        int r=0;
        char[] c=s.toCharArray();
        int maxValue=Integer.MIN_VALUE;
        while(r<s.length()){
            if(c[r]=='a'||c[r]=='e'||c[r]=='i'||c[r]=='o'||c[r]=='u'){
                count++;
            }
            if(r-l+1==k){
                maxValue=Math.max(maxValue,count);
                if(c[l]=='a'||c[l]=='e'||c[l]=='i'||c[l]=='o'||c[l]=='u'){
                    count--;
                }
                l++;
            }
            r++;
        }
        return maxValue;
    }
}