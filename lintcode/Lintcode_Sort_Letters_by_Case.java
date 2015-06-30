//http://www.lintcode.com/en/problem/sort-letters-by-case/
public class Lintcode_Sort_Letters_by_Case {
	public void sortLetters(char[] chars) {  // Two pointer partition
        if(chars==null||chars.length<2) return;
        int n=chars.length;
        int i=0,j=n-1;
        while(i<j) {
            while(i<j&&chars[i]>='a'&&chars[i]<='z') i++;
            while(i<j&&chars[j]>='A'&&chars[j]<='Z') j--;
            if(i<j) {
                char temp=chars[i];
                chars[i]=chars[j];
                chars[j]=temp;
                i++;
                j--;
            }
        }
    }
}
