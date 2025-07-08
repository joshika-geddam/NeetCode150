class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        while(right<arr.length){
            sum=sum+arr[right];
            if(right-left+1==k){
                if(sum/k>=threshold){
                    count++;
                }
                sum=sum-arr[left];
                left++;
            }
            right++;
        }
        return count;
    }
}