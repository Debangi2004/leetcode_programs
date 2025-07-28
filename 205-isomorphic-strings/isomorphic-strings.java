class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hash = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();

        int n =s.length();
        int m = t.length();
        if(n!=m) return false;

        for(int i = 0 ;i<n;i++){
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if(hash.containsKey(cS)){
                if(hash.get(cS)!=cT) return false;
            }
            else{
                if(mapped.contains(cT)) return false;
                hash.put(cS,cT);
                mapped.add(cT);
            }
        }
        return true;
    }
}
