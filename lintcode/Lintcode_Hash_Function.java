//http://www.lintcode.com/en/problem/hash-function/
public class Lintcode_Hash_Function {
    public int hashCode(char[] key,int HASH_SIZE) {
        if(key==null||key.length==0) return 0;
        
        int mult=33;
        long val=0;
	for(int i=0;i<key.length;i++) {
	    val= (val*mult+key[i]) % HASH_SIZE;
	}
	return (int)val;
    }
}
