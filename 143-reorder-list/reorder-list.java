class Solution {
    private ListNode reverse(ListNode node){
        ListNode temp = node;
        ListNode prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    private ListNode middle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        ListNode mid = middle(head);
        ListNode rev = reverse(mid.next);
        mid.next = null;

        ListNode c1 = head;
        ListNode c2 = rev;
        ListNode f1 = null;
        ListNode f2 = null;

        while(c1 != null && c2 != null){
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1= f1;
            c2 = f2;
        }
    }
}