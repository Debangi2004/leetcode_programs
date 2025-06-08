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
    public ListNode removeNthFromEnd(ListNode head, int N) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        ListNode temp = head;

        // Count the number of nodes in the linked list
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // If N equals the total number of nodes, delete the head
        if (cnt == N) {
            ListNode newhead = head.next;
            head = null;
            return newhead;
        }

        // Calculate the position of the node to delete (res)
        int res = cnt - N;
        temp = head;

        // Traverse to the node just before the one to delete
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        // Delete the Nth node from the end
        ListNode delNode = temp.next;
        temp.next = temp.next.next;
        delNode = null;
        return head;
    }
}