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
    
    public ListNode getKthNode(ListNode temp, int k) {
        k = k - 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode previous = null;

        while (temp != null) {
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                break; // Not enough nodes to reverse
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            // Reverse current group
            ListNode newHead = reverse(temp);

            if (previous == null) {
                head = newHead; // First group becomes new head
            } else {
                previous.next = newHead;
            }

            // Connect the last node of reversed group to nextNode
            temp.next = nextNode;

            // Move pointers for next iteration
            previous = temp;
            temp = nextNode;
        }

        return head;
    }
}
