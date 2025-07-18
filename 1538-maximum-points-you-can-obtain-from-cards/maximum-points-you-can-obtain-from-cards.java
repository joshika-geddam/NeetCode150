class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0,rightSum=0;
        int totalSum=0;
        for(int i=0;i<k;i++){
            leftSum=leftSum+cardPoints[i];
        }
        totalSum=leftSum;
        int rightIndex=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum=leftSum-cardPoints[i];
            rightSum=rightSum+cardPoints[rightIndex];
            rightIndex--;
            totalSum=Math.max(totalSum,leftSum+rightSum);
        }
        
        return totalSum;
        
    }
}