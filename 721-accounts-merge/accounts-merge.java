import java.io.*;
import java.util.*;

class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        // Step 1: Union emails with same accounts
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String mail = account.get(j);
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.union(i, mapMailNode.get(mail));
                }
            }
        }

        // Step 2: Group all emails by parent
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.find(it.getValue());
            mergedMail[node].add(mail);
        }

        // Step 3: Prepare answer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // Add username
            temp.addAll(mergedMail[i]);       // Add sorted emails
            ans.add(temp);
        }

        return ans;
    }
}
