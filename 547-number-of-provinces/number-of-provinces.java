class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> ans,int src,int[] vis){
        vis[src]=1;
        for(int it : ans.get(src)){
            if(vis[it]==0){
                dfs(ans,it,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i =0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    ans.get(i).add(j);
                    ans.get(j).add(i);
                }
            }
        }
        int count=0;
        int vis[]= new  int[n];
        for(int i =0;i<n;i++){
            if(vis[i]==0){
                count++;
                dfs(ans,i,vis); 
            }
        }
        return count;
    }
}