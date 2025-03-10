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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k<0){
            return head;
        }
        int count=0;
        ListNode node=head;
        while(node!=null && count<k){
            node=node.next;
            count++;
        }
        while(count==k){
            ListNode current=head;
            ListNode prev=null;
            ListNode next=null;
            for(int i=0;i<k;i++){
                next=current.next;
                current.next=prev;
                prev=current;
                current=next;
            }
            head.next=reverseKGroup(current,k);
            return prev;
        }
        return head;
    }
}