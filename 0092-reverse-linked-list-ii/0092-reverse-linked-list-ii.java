class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right){




ListNode curr= head;
ListNode prev=null;

for(int i=1;i<left;i++){
prev=curr;
curr=curr.next;
}

 ListNode connection = prev; // node before left
    ListNode tail = curr;       // will become tail after reverse
ListNode next=null;

for(int i=0;i<right-left+1;i++){
    next =curr.next;
    curr.next=prev;
    prev=curr;
    curr=next;
}
if (connection != null) {
        connection.next = prev;
    } else {
        head = prev; 
    }

    tail.next = curr;

    return head;

    }
};