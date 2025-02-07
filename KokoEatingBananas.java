class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed=1;
        int maxSpeed=0;
        for(int pile:piles){
            maxSpeed=Math.max(maxSpeed,pile);
        }
        while(minSpeed<maxSpeed){
            int mid=minSpeed+(maxSpeed-minSpeed)/2;
            if(canEat(piles,h,mid)){
                maxSpeed=mid;
            }
            else{
                minSpeed=mid+1;
            }
        }
        return minSpeed;
    }
    public boolean canEat(int[] piles,int h,int mid){
        int hours=0;
        for(int pile:piles){
            hours+=(int)Math.ceil((double)pile/mid);
        }
        return hours<=h;
    }
}
