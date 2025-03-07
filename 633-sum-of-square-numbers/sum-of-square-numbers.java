class Solution {
    public boolean judgeSquareSum(int c) {
        int left=0;
        long right=((int)Math.sqrt(c));
        while(left<=right){
            long sum=(long)(left*left+(right*right));
            if(sum>c){
                right--;
            }
            else if(sum<c){
                left++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}