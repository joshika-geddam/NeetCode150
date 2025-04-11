class Solution {
    public int maxProfit(int[] prices) {
        int sold=Integer.MIN_VALUE;
        int held=Integer.MIN_VALUE;
        int result=0;
        for(int price:prices){
            int prevSold=sold;
            sold=price+held;
            held=Math.max(held,result-price);
            result=Math.max(result,prevSold);
        }
        return Math.max(sold,result);
    }
}