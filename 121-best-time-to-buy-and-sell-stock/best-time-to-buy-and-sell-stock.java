class Solution {
    public int maxProfit(int[] prices) {
        int current=prices[0];
        int bestPrice=prices[0];
        int maxPrice=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<bestPrice){
                bestPrice=prices[i];
            }
            else{
                current=prices[i]-bestPrice;
                maxPrice=Math.max(current,maxPrice);
            }
        }
        return maxPrice;
    }
}