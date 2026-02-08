class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLen = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums) map.put(num, false);

        for(int num : nums){
            if(map.get(num) == true) continue;
            map.put(num, true);
            int currLen=1;
            
            int nextNum= num+1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false){
                currLen++;
                map.put(nextNum, true);
                nextNum++;
            }

            int prevNum= num-1;
            while(map.containsKey(prevNum) && map.get(prevNum) == false){
                currLen++;
                map.put(prevNum, true);
                prevNum--;
            }

            longestLen = Math.max(longestLen, currLen);
        }
        return longestLen;
    }
}