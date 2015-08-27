//http://www.lintcode.com/en/problem/delete-digits/
//Given an integer A = "178542", k = 4  return a string "12"
/* From left to right, find the first descending position. Digit in the left side has more significant than digit in the right.
 * Delete a digit and move pointer i to left, to reconsider the relation between current i and i+1
 * Greedy, Time Complexity: O(nk) */
public class Lintcode_Delete_Digits {
	public String DeleteDigits(String A, int k) {
        if(A.length()<2) return A;
        int i=0;
        StringBuilder s=new StringBuilder(A);
        while(i<s.length()-1){
            if(i>=0&&s.charAt(i)>s.charAt(i+1)){
                s.deleteCharAt(i);
                k--;
                if(k==0) break;
                i--;
            }
            else i++;
        }
        i=s.length()-1;
        while(k>0&&i>=0){   //the remaining chars in A are in ascending order. e.g. A="111" k=1, remove 11  or A="123" k=1 remove 3 and 2
            s.deleteCharAt(i);
            i--;
            k--;
        }
        while(s.charAt(0)=='0'&&s.length()>1){
            s.deleteCharAt(0);
        } 
        return s.toString();
    }
}
