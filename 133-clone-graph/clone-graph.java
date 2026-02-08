/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> cloneMap = new HashMap<>();
        Node cloneNode = new Node(node.val);
        cloneMap.put(node,cloneNode);

        Queue<Node> q=new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node curr=q.poll();
            Node cloneCurr=cloneMap.get(curr);

            for(Node neighbor : curr.neighbors){
                if(!cloneMap.containsKey(neighbor)){
                    Node newNode = new Node(neighbor.val);
                    cloneMap.put(neighbor, newNode);
                    q.add(neighbor);
                }
                cloneCurr.neighbors.add(cloneMap.get(neighbor));
            }
        }
        return cloneNode;
    }
}