class Solution {
    public int missingNumber(int[] nums) {
        int allXor=0;
        for(int i=0;i<=nums.length;i++){
            allXor=allXor^i;
        }
        for(int num:nums){
          allXor=allXor^num;
        }
        return allXor;
    }
}