class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int hash[]= new int[26];

        for(int i =0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }

        for(int count : hash){
            if(count != 0) return false;
        }
        return true;
    }
}