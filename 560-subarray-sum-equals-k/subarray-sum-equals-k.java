class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int count = 0;
        int n  = nums.length;
        int ps[] = new int[n];
        ps[0]=nums[0];
        for(int i =1;i<n;i++){
            ps[i] = ps[i-1]+nums[i];
        }
        for(int j =0;j<n;j++){
            if(ps[j]==k){
                count++;
            }
            int val = ps[j]-k;
            if(map.containsKey(val)){
                count+=map.get(val);
            }
            map.put(ps[j],map.getOrDefault(ps[j],0)+1);
        }
        return count;
    }
}