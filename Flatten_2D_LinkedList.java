/* Each node in the singly LinkedList has two pointers: next and down, flatten it by removing the down pointers
1->2->4  ==>   1->2->3->6->5->4
   |
   3->5
   |
   6
*/
public class Flatten_2D_LinkedList {
	public static ListNode flatten(ListNode cur) {
		if(cur==null) return null;
		ListNode next = cur.next;
		if(cur.down!=null) {
			cur.next=cur.down;
			cur.down=null;
			cur = flatten(cur.next);			
		}
		if(next!=null) {
			cur.next=next;
			cur = flatten(next);		
		}
		return cur;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(4);
		head.next.down=new ListNode(3);
		head.next.down.next=new ListNode(5);
		head.next.down.down=new ListNode(6);
		flatten(head);
		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
	}
}
