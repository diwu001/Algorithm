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
    // Solution 1: Time O(n), Space O(n): use HashMap to store the relationship between each node and its copy
    RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode l1 = head, l2 = newHead;
        while(l1.next != null) {
            RandomListNode cur = new RandomListNode(l1.next.label);
            map.put(l1.next, cur);
            l2.next = cur;
            l2 = cur;
            l1 = l1.next;
        }
        l1 = head; l2 = newHead;
        while(l1 != null) {
            if(l1.random != null) {
                map.get(l1).random = map.get(l1.random);
            }
            l1 = l1.next;
        }
        return newHead;
    }
    
    // Solution 2: Time O(n), Space O(1): store the copy node as current node.next
    RandomListNode copyRandomList(RandomListNode head) {
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
