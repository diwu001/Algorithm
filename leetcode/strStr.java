// strStr("mississippi", "issi"), return 1
// Rabin-Karp algorithm
public class strStr {
	public static int strStr(String haystack, String needle) {
		if(haystack==null||needle==null||haystack.length()<needle.length()) return -1;
        if(haystack.length()==0) return needle.length()==0?0:-1;
        if(needle.length()==0) return 0;
        
        int hn=0,hh=0;
        int base=26, mod=997;
        int power=1;
        for(int i=0;i<needle.length();i++) {
            power= (i==0)? 1 : (power*base)%mod;
            hn= (hn*base+(needle.charAt(i)-'a'))%mod;
            hh= (hh*base+(haystack.charAt(i)-'a'))%mod;
        }
        if(hh<0) hh+=mod;
        if( hn==hh && needle.equals(haystack.substring(0,needle.length())) ) return 0;
        
        for(int i=needle.length();i<haystack.length();i++) {
            hh = hh- ((haystack.charAt(i-needle.length())-'a')*power)%mod;
            if(hh<0) hh+=mod;
            hh=(hh*base + (haystack.charAt(i)-'a'))%mod;
            if( hn==hh && needle.equals(haystack.substring(i-needle.length()+1,i+1)) ) return i-needle.length()+1;
        }
        
        return -1;
    }
}
