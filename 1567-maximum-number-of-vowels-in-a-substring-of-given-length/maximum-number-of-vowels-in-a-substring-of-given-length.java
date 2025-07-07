class Solution {
    public int maxVowels(String s, int k) {
        char[] v=s.toCharArray();
        int l=0;
        int r=0;
        int count=0;
        int maxCount=Integer.MIN_VALUE;
        while(r<v.length){
            if(v[r]=='a'||v[r]=='e'||v[r]=='i'||v[r]=='o'||v[r]=='u'){
                count++;
            }
            if(r-l+1==k){
                
                maxCount=Math.max(maxCount,count);
                  if(v[l]=='a'||v[l]=='e'||v[l]=='i'||v[l]=='o'||v[l]=='u'){
                count--;
            }              
                l++;

            }
            r++;
        }
        return maxCount;
    }
}