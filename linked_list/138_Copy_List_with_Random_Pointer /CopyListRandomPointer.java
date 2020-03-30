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
        Node node = head;
        
        // create new Node
        while(node!=null){
            Node temp = new Node(node.val); //new node
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        
        node = head; // back to start point 
        //deal with random
        while(node!= null){
            if(node.random!= null){
                node.next.random = node.random.next;
            }
            node = node.next.next; // skip new node
        }
        
        Node newHead = new Node(0);
        Node currNode = head; //reiterate
        node = newHead ;
        
        while(currNode!= null){
            node.next = currNode.next;
            currNode.next = currNode.next.next;
            currNode = currNode.next;
            node = node.next;
        }
        return newHead.next;
    }
}