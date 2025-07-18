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
        if(head==null ||k<0){
            return null;
        }
        ListNode node=head;
        int count=0;
        while(node!=null && count<k){
            node=node.next;
            count++;
        }
        while(count==k){
            ListNode current=head;
            ListNode prev=null;
            ListNode newNode=null;
            for(int i=0;i<k;i++){
                newNode=current.next;
                current.next=prev;
                prev=current;
                current=newNode;

            }
            head.next=reverseKGroup(current,k);
            return prev;
        }
        return head;
        
    }
}