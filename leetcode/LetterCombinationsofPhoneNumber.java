//Leetcode - BFS
import java.util.*;
public class LetterCombinationsofPhoneNumber {
	String[] dict = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if(digits==null||digits.length()==0) return res;
        Queue<String> q = new LinkedList<String>();
        String s0 = dict[digits.charAt(0)-'1'];
        for(int i=0;i<s0.length();i++) q.offer(s0.substring(i,i+1));
        for(int i=1;i<digits.length();i++) {
            while(!q.isEmpty()) {
                String cur=q.peek();
                if(cur.length()>i) break;
                q.poll();
                String si = dict[digits.charAt(i)-'1'];
                for(int j=0;j<si.length();j++) q.offer(cur+si.substring(j,j+1));
            }
        }
        while(!q.isEmpty()) res.add(q.poll());
        return res;
    }
}
