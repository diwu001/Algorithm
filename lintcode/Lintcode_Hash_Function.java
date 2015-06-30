//http://www.lintcode.com/en/problem/hash-function/
public class Lintcode_Hash_Function {
	 public int hashCode(char[] key,int HASH_SIZE) {
	        if(key==null||key.length==0) return 0;
	        int hash = 0;
	        long base = 1;  // HASH_SIZE may be very large
	        for(int i=key.length-1;i>=0;i--) {
	            int val = (int)((key[i]*base)%HASH_SIZE);
	            base = (base*33)%HASH_SIZE;
	            hash = (hash +  val)%HASH_SIZE;
	        }
	        return hash%HASH_SIZE;
	    }
}
