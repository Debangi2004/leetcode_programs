class Solution {
    public void findCombination( int ind, int target, int[] candidate, List<List<Integer>>ans, List<Integer> ds){
        if(ind==candidate.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(candidate[ind]<=target){
            ds.add(candidate[ind]);
            findCombination(ind, target-candidate[ind], candidate, ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombination(ind+1, target, candidate, ans, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombination(0, target, candidates, ans, ds);
        return ans;
    }
}