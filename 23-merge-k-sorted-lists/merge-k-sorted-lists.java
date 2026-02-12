class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode node : lists){
            if(node != null) pq.offer(node);
        }

        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            temp.next = curr;
            temp = temp.next;
            if(curr.next != null) pq.offer(curr.next);
        }
        return dummy.next;
    }
}