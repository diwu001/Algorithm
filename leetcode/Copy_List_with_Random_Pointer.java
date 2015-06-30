/*A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
  Return a deep copy of the list.*/
  
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
public class Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode node = head;
        
		// Copy nodes and next pointer
		while(node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        
		// Copy random pointer
        node = head;
        while(node != null) {
            if(node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        
		// Split to two lists
        node = head;
        RandomListNode newhead = head.next;
        while(node != null) {
            RandomListNode copy = node.next;
            node.next = copy.next;
            if(copy.next!=null) copy.next = copy.next.next;
            node = node.next;
        }
        return newhead;
    }
}
