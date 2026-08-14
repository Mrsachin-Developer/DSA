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

    public ListNode findMiddle(ListNode head) {
        //Tortoise and hare algo just with a small change as we the first midddle 
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;

            } else {
                temp.next = list2;
                list2 = list2.next;

            }
            temp = temp.next;

            // If any list still has remaining
            if (list1 != null) {
                temp.next = list1;
            } else {
                temp.next = list2;
            }

        }
        // Return the merged list starting 
        // from the next of the dummy node
        return dummyNode.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
             middle.next=null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeTwoList(leftHead, rightHead);

    }
}