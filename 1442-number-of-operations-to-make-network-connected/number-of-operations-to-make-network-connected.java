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
            parent[pv]  = pu;
            size[pu] += size[pv];
        }
    }
}
class Solution {

    public int makeConnected(int n, int[][] connections){
        if (connections.length < n - 1) return -1;

        int extras=0;

        DisjointSet ds = new DisjointSet(n);
        for (int[] edge : connections) {
            ds.union(edge[0], edge[1]);
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.find(i) == i) {
                components++;
            }
        }
        return components - 1;
    }
}

