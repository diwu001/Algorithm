public class List_is_Palindrome {
	// Check whether or not a singly linkedlist is a palindrome list
	// Find the middle node of the list, then reverse the 2nd half of the list, then compare
	public static boolean isPalindrome(ListNode head) {	 
	    if(head==null||head.next==null) return true;
		ListNode slow = head;
	    ListNode fast = head.next;

	    while (fast != null && fast.next != null) {
	      slow = slow.next;
	      fast = fast.next.next;
	    }
	    
	    fast=slow;
	    slow=slow.next;
	    fast.next=null;
	    
	    ListNode newhead = null;
	    while(slow!=null) {
	    	ListNode next=slow.next;
	    	slow.next=newhead;
	    	newhead=slow;
	    	slow=next;
	    }
	    
	    ListNode p = head;
	    slow=newhead;//slow half is shorter or equal to p half
	    while (slow != null) {
	      if (slow.val != p.val) {
	        return false;
	      }
	      slow = slow.next;
	      p=p.next;
	    }
	    return true;
	  }
}
