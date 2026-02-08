class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node : lists){
            if(node!=null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode curr= pq.poll();
            temp.next =curr;
            temp =temp.next;
            if(curr.next != null) pq.offer(curr.next);
        }
        return dummy.next;
    }
}