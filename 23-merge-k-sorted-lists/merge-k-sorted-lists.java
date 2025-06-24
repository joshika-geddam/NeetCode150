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
        if(lists.length==0 || lists==null){
            return null;
        }
        return mergeKLists(lists,0,lists.length-1);
    }
    public ListNode mergeKLists(ListNode[] lists,int start,int end){
        if(start==end){
            return lists[start];
        }
        int mid=start+(end-start)/2;
        ListNode l1=mergeKLists(lists,start,mid);
        ListNode l2=mergeKLists(lists,mid+1,end);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
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