class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1){
            return 0;
        }      
        int[] dp=new int[amount+1];
        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int coin:coins){
                if(i>=coin &&dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(1+dp[i-coin],dp[i]);
                }
            }
        }  
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}