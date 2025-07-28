class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hash=new HashMap<>();
        if(s.length() != t.length())return false;
        for(char ch : s.toCharArray()){
            hash.put(ch,hash.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            if(!hash.containsKey(ch)) return false;
            hash.put(ch,hash.get(ch)-1);
            if(hash.get(ch)<0) return false;
        }
        return true;
    }
}