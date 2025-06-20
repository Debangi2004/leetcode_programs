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
            parent[node] = find(parent[node]); // Path compression
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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0, maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // +2 to prevent out-of-bound issues
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        Set<Integer> nodesInvolved = new HashSet<>();

        for (int[] stone : stones) {
            int rowNode = stone[0];
            int colNode = stone[1] + maxRow + 1; // shift column index
            ds.union(rowNode, colNode);
            nodesInvolved.add(rowNode);
            nodesInvolved.add(colNode);
        }

        int components = 0;
        for (int node : nodesInvolved) {
            if (ds.find(node) == node) {
                components++;
            }
        }

        return n - components; // Max stones that can be removed
    }
}
