//http://www.lintcode.com/en/problem/compare-strings/
public class Lintcode_Compare_Strings {
	/**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
	public boolean compareStrings(String A, String B) {
        if(A==null||B==null) return false;
        if(A.length()==0) return B.length()==0? true:false;
        if(B.length()==0) return true;
        if(A.length()<B.length()) return false;
        
        int[] c = new int[26];
        for(int i=0;i<A.length();i++) {
            c[A.charAt(i)-'A']++;
        }
        for(int i=0;i<B.length();i++) {
            int pos = B.charAt(i)-'A';
            c[pos]--;
            if(c[pos]<0) return false;  //B has a char not in A, or the number of char in B is greater than that in A
        }
        return true;
    }
}
