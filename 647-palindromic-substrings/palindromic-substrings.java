class Solution {
    public int countSubstrings(String s) {
        int n =s.length();
        int count=0;
        for(int i =0;i<n;i++){
            count+= expandFromCentre(s,i,i);
            count+= expandFromCentre(s,i,i+1);
        }
        return count;
    }
    private int expandFromCentre(String s, int left, int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}