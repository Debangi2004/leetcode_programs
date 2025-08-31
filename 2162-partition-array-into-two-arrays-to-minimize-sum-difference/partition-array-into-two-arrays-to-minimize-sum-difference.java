class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int total= Arrays.stream(nums).sum();
        int target = total/2;
        
        int[] left = Arrays.copyOfRange(nums,0,n/2);
        int[] right = Arrays.copyOfRange(nums,n/2,n);

        Map<Integer,List<Integer>> leftSum = generateSum(left);
        Map<Integer,List<Integer>> rightSum = generateSum(right);

        int ans=Integer.MAX_VALUE;

        for(int leftSize : leftSum.keySet()){
            int rightSize = n/2-leftSize;
            if(!rightSum.containsKey(rightSize)) continue;

            List<Integer> lList = leftSum.get(leftSize);
            List<Integer> rList = rightSum.get(rightSize);

            Collections.sort(rList);

            for(int sumLeft : lList){
                int need = target-sumLeft;
                int idx=Collections.binarySearch(rList,need);
                if(idx<0){
                    idx=-idx-1;
                }
                if(idx<rList.size()){
                    int sumRight = rList.get(idx);
                    int sum=sumRight+sumLeft;
                    ans = Math.min(ans,Math.abs(total-2*sum));
                }
                if(idx>0){
                    int sumRight = rList.get(idx-1);
                    int sum=sumRight+sumLeft;
                    ans = Math.min(ans,Math.abs(total-2*sum));
                }
            }
        }
        return ans;
    }
    private Map<Integer,List<Integer>> generateSum(int[] left){
        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = left.length;
        int subset=1<<n;
        for(int i =0;i<subset;i++){
            int sum=0;
            int bits=0;
            for(int j=0;j<n;j++){
                if((i&(1 << j)) != 0){
                    sum+=left[j];
                    bits++;
                }
            }
            map.computeIfAbsent(bits,k-> new ArrayList<>()).add(sum);
        }
        return map;
    }
}
