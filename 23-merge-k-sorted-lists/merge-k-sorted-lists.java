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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        return mergeKLists(lists,0,lists.length-1);
    }
    public ListNode mergeKLists(ListNode[] lists,int left,int right){
        if(left==right){
            return lists[left];
        }
        int mid=left+(right-left)/2;
        ListNode l1=mergeKLists(lists,left,mid);
        ListNode l2=mergeKLists(lists,mid+1,right);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode ptr=dummy;
        while(l1!=null && l2!=null){
        if(l1.val<=l2.val){
            dummy.next=l1;
            l1=l1.next;
        }  
        else{
            dummy.next=l2;
            l2=l2.next;
        } 
        dummy=dummy.next;
        } 

        if(l1==null){
            dummy.next=l2;
        }
        if(l2==null){
            dummy.next=l1;
        }
        return ptr.next;

    }
}