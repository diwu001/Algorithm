//http://www.lintcode.com/en/problem/rehashing/
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Lintcode_Rehashing {
	/**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */ 
	public ListNode[] rehashing(ListNode[] hashTable) {
        int oldLen=hashTable.length;
        if(oldLen==0) return hashTable;
        int newLen=oldLen*2;  
        ListNode[] result = new ListNode[newLen];
        for(int i=0;i<oldLen;i++) {
            ListNode cur = hashTable[i];  
            while(cur!=null) {
                int val=cur.val;
                // if a<0, we calculate a % b = (a % b + b) % b to make it is a non negative integer. e.g. -1%3=2 -4%3=2 
                int newPos=(val>0)? val%newLen : (val%newLen+newLen)%newLen;  
                if(result[newPos]==null) {
                    result[newPos]=new ListNode(val);
                } else {
                    ListNode temp=result[newPos];  //insert new Node after last element in the list result[newPos]
                    while(temp.next!=null) {
                        temp=temp.next;
                    }
                    temp.next=new ListNode(val);
                }
                cur=cur.next;
            }
        }
        return result;
    }
}
