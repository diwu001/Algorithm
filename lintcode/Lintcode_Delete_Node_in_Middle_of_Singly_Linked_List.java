//http://www.lintcode.com/en/problem/delete-node-in-the-middle-of-singly-linked-list/
//Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
//Given 1->2->3->4, and node 3. return 1->2->4
public class Lintcode_Delete_Node_in_Middle_of_Singly_Linked_List {
	public void deleteNode(ListNode node) {
        if(node==null||node.next==null) {
            node=null;
            return;
        } 
        node.val=node.next.val;  //copy the value of the next node and delete the next node
        node.next=node.next.next;
    }
}
