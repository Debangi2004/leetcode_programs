class Solution {
    public int findContentChildren(int[] children, int[] cookie) {
        Arrays.sort(children);
        Arrays.sort(cookie);

        int cookieSize = 0;
        int greed = 0;
        
        while(cookieSize<cookie.length && greed<children.length){
            if(cookie[cookieSize]>=children[greed]){
                greed++;
            }
            cookieSize++;
        }
        return greed;
        
    }
}