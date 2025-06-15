class Pair{
    int first,second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.first-y.first);
        int m=times.length;
        int[] dist=new int[n+1];
        for(int i=0;i<=n;i++){
                dist[i]=(int)(1e9);
        }
        dist[k]=0;
        pq.add(new Pair(0,k));
        while(pq.size()!=0){
            int dis=pq.peek().first;
            int node=pq.peek().second;
            pq.remove();
            if (dis != dist[node]) continue;

            for(int i=0;i<times.length;i++){
               int u  = times[i][0];
                int v  = times[i][1];
                int wt = times[i][2];

                if (u != node) continue;

                if (dis + wt < dist[v]) {         
                    dist[v] = dis + wt;
                    pq.add(new Pair(dist[v], v));
                }
            }
        }
       int ans = 0;
        for (int i = 1; i <= n; i++) {
            //If the node is unreachable return -1
            if (dist[i] == (int)(1e9)) return -1;        
            ans = Math.max(ans, dist[i]);
        }
        return ans;

    }
}