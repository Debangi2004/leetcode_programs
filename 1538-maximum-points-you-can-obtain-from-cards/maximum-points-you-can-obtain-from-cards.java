class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;
        int n = cardPoints.length;
        for(int i =0; i<k ;i++)
        {
            lsum = lsum+cardPoints[i];
            maxSum = lsum;
        }

        int rindex=n-1;
        for (int i = k - 1; i >= 0; i--)

        {
            lsum = lsum-cardPoints[i];
            rsum = rsum+cardPoints[rindex];
            rindex--;
            maxSum = Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}