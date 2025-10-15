class Solution {
    public boolean checkValidString(String s) {
        int min =0;
        int max =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }
            else if(s.charAt(i)==')'){
                min--;
                max--;
            }
            else{
                min=min-1;
                max=max+1;
            }
            if(max<0) return false;
            if(min<0) min=0;
        }
        return min==0;
    }
}