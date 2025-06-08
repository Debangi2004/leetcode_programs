/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    ListNode reverse(ListNode head){
    if(head == null || head.next == null) return head;

    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}


    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode mid = middle(head);
        ListNode k = reverse(mid.next);
        mid.next = null;
        
        ListNode c1 = head;
        ListNode c2 = k;
        ListNode f1 = null;
        ListNode f2 = null;
        
        while(c1 != null && c2 != null){
            f1 = c1.next;
            f2 = c2.next;
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
    }
}