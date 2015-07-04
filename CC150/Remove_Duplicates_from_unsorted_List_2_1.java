import java.util.HashSet;
public class Remove_Duplicates_from_unsorted_List_2_1 {
	// Time O(n2) Space O(1)
	static void deleteDuplicates(ListNode head){
		if (head == null) return;
		ListNode cur = head;
		while(cur != null){
			ListNode runner = cur;
			while(runner.next!=null) {
				if(runner.next.val == cur.val){
					runner.next = runner.next.next;
			    } else{
			    	 runner = runner.next;
			    }
			}
			cur=cur.next;
		}		     
	}
	
	// Time O(n) Space O(n)
	static void deleteDuplicates2(ListNode head){
		if (head == null) return;
		ListNode cur = head, pre=head;
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(cur!=null) {
			if(set.contains(cur.val)) {
				pre.next=cur.next;
			} else {
				set.add(cur.val);
				pre=cur;
			}
			cur=cur.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode head= new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		deleteDuplicates2(head);
		ListNode cur=head;
		while(cur!=null) {System.out.println(cur.val); cur=cur.next;}
		//deleteDuplicates2(head);
	}
}
