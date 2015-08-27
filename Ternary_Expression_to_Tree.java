/*Ternary expressions are expressions of the following form: condition ? value_if_true : value_if_false.
 *  If the value of condition is TRUE, the expression evaluates to value_if_true, otherwise it evaluates to value_if_false.
 * For the context of this question, all of the operands in the expression are either a variable name or another ternary expression. 
 * The variable names are single character lowercase english letters.
 * For example, a valid expression would be "a?b?c:d:e". This expression can be represented in a tree form, for example:
		a
	   / \
	  b   e
	/ \
	c   d
*/

import java.util.*;
public class Ternary_Expression_to_Tree {
	/*class Node {
        Character variableName;
        Node left, right;
	}*/
	
	/* Time Complexity / Space Complexity : O(n)
	   Preprocess the input string. Use a stack to find all matching '?' and ':'. Store their index in a hashmap <index of '?', index of ':'>
	   Then build the binary tree by inorder traversal */
	 public static TreeNode parseTenary3(String s) {
		 Stack<Integer> stack = new Stack<Integer>();
		 HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		 for(int i=0;i<s.length();i++) {
			 if(s.charAt(i)=='?') {
				 stack.push(i);
			 } else if(s.charAt(i)==':') { 
				 if(!stack.isEmpty()) {
					 int pos=stack.pop();
					 map.put(pos, i);
				 }
			 }
		 }
		 return helper(map,s,0,s.length()-1);
	 }
	 
	 public static TreeNode helper(HashMap<Integer,Integer> map, String s, int i, int j) {
         if(i==j) return new TreeNode(s.charAt(i));
         TreeNode root=new TreeNode(s.charAt(i));
         root.left=parseHelp(s,i+2,map.get(i+1)-1);
         root.right=parseHelp(s,map.get(i+1)+1,j);
         return root;
	 }
}
