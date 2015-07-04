
public class s2_is_Rotation_of_s1_1_8 {
	public static boolean isRotation(String s1, String s2) {
		int m=s1.length();
		if(m==s2.length()&&m>0) {
			String s1s1=s1+s1;//divide s1s1 into s1,s1
			return isSubstring(s1s1,s2);//call isSubTring
		}
		return false;
	}
		
		
	public static boolean isSubstring(String haystack, String needle) {
	    if(haystack==null||needle==null) return false;
	    int m = haystack.length();
	    int n = needle.length();
	    if(n==0) return true;
	    if(m==0) return false;
	    if(n>m) return false;
	    for(int i=0;i<=m-n;i++) {
	        int j=0;
	        for(;j<n;j++) {
	            if(haystack.charAt(i+j)!=needle.charAt(j)) {
	                break;
	            }
	        }
	        if(j==n) return true;
	    }
	    return false;
	}
		
	public static void main(String args[]) {
		String s1 = "abcd";
		String s2 = "cdab";  //abcdabcd
		System.out.println(isRotation(s2, s1));	
	}		
}
