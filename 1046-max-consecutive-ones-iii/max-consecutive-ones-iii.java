class Solution {
    public int longestOnes(int[] arr, int k) {
        int l=0;
        int r=0;
        int maxLen=0;
        int count=k;
        while(r<arr.length){
            if(arr[r]==0){
                count--;
            }
                if(count<0){
                    if(arr[l]==0){
                        count++;
                    }
                    l++;
                }
                maxLen=Math.max(maxLen,r-l+1);
                r++;
        }
        return maxLen;
        
    }
}