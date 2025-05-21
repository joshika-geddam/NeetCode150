/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node current=head;
        while(current!=null){
            Node newNode=new Node(current.val);
            newNode.next=current.next;
            current.next=newNode;
            current=newNode.next;
        }
        current=head;
        while(current!=null){
            if(current.random!=null){
                current.next.random=current.random.next;
            }
            current=current.next.next;
        }
        current=head;
        Node newHead=current.next;
        Node newCurr=newHead;
        while(current!=null){
            current.next=newCurr.next;
            current=current.next;
            if(current!=null){
                newCurr.next=current.next;
                newCurr=newCurr.next;
            }
        }
        return newHead;
        
    }
}