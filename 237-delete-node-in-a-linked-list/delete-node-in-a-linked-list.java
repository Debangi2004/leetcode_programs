public class Solution {
    public void deleteNode(ListNode node) {
        // Delete the given node (can't delete tail node this way)
        if (node == null || node.next == null) return;

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
