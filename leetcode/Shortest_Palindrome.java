
public class Shortest_Palindrome {	
	public static String shortestPalindrome(String s) {
		if(s==null||s.length()==0) return "";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String t = sb.toString();
        int n=s.length();
        
        int x=0,y=n-1;
        while(x<y) {
            if(s.charAt(x)!=s.charAt(y)) break;
            x++;
            y--;
        }
        if(x==y) return s;
        
        int i=n-1;
        for(;i>=0;i--) {
        	int count=i,j=n-1;
        	while(count>=0) {
        		if(t.charAt(j)!=s.charAt(count)) break;
        		count--;
        		j--;
        	}
        	if(count<0) break;
        }
        StringBuilder sb2 = new StringBuilder(s.substring(i+1,n));
        sb2.reverse();
        String add = sb2.toString();
        
        return add+s;
    }
}
