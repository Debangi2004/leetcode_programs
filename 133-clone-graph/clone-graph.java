
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Node cloneNode = new Node(node.val);
        HashMap<Node, Node> cloneMap = new HashMap<>();
        cloneMap.put(node, cloneNode);

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            Node cloneCurr = cloneMap.get(curr);

            for(Node neighbor : curr.neighbors){
                if(!cloneMap.containsKey(neighbor)){
                    Node newNode = new Node(neighbor.val);
                    cloneMap.put(neighbor, newNode);
                    q.offer(neighbor);
                }
                cloneCurr.neighbors.add(cloneMap.get(neighbor));
            }
        }
        return cloneNode;
    }
}