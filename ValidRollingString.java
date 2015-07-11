//http://www.fgdsb.com/2015/01/16/valid-rolling-string/
/*检查一个字符串是否包含k位a进制数的所有表示形式。
保证原字符串的所有字串都是合法的k位a进制数。"00110", a=2, k=2 => true （包括了00，01，10，11）
可以用rolling hash做，复杂度是O(N)。当然当字符串很大的话，naive的rolling hash肯定溢出了。
下面的代码假设1 <= a <= 10*/
import java.util.HashSet;
public class ValidRollingString {
	public static boolean check_valid(String s, int a, int k) {
		if(s==null||k<=0||a<=0) return false;
		int n=s.length();
		int all_kinds = (int)Math.pow(a,k);
	    if(n < all_kinds + k -1) return false;
	    long hash = 0, base = 1;
	    for(int i = k-1; i >= 0; --i) {
	        int num = s.charAt(i) - '0';
	        if(num >= a) return false;
	        hash += num * base;
	        base *= 29;
	    }
	    base /= 29;
	    
	    HashSet<Long> record = new HashSet<Long>();
	    record.add(hash);
	    for(int i = k; i < n; ++i) {
	        int num = s.charAt(i) - '0';
	        if(num >= a) return false;
	        hash = (hash-(s.charAt(i-k)-'0')*base) * 29 + num;
	        record.add(hash);
	    }
	    return record.size() == all_kinds;
	}
	
	public static void main(String[] args) {
		System.out.println(check_valid("0011",2,2)); //false
		System.out.println(check_valid("001103",2,2)); //false
		System.out.println(check_valid("10110",2,2)); //false
		System.out.println(check_valid("00110",2,2)); //true
		System.out.println(check_valid("00111",2,2)); //false
		System.out.println(check_valid("4537860129",10,1)); //true
		System.out.println(check_valid("0123456789",10,2)); //false
	}
}
