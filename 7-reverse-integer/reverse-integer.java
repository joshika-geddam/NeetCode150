class Solution {
    public int reverse(int x) {
        long sum=0;
        while(x!=0){
            sum=(sum*10)+(x%10);
            if(sum<Integer.MIN_VALUE|| sum>Integer.MAX_VALUE){
                return 0;
            }
            x=x/10;
        }
        return (int) sum;
        
    }
}