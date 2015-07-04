public class String_Has_Unique_Chars_1_1 {
	// Time O(n), Space O(256)
	public static boolean isUniqueChars(String str) {
		boolean[] temp = new boolean[256];
		for(int i=0;i<str.length();i++) {
			int c = str.charAt(i);
			if(temp[c]==true) return false;
			temp[c] = true;
		}
		return true;
	}
	
	// Time O(n), Space O(32)
	public static boolean isUniqueChars2(String str) {
		int check=0;
		for(int i=0;i<str.length();i++) {
			int pos=str.charAt(i)-'a';
			if( (check & (1<<pos))>0 ) return false;
			check |= (1<<pos);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s="abcdefgha";
		System.out.println(isUniqueChars(s));
		System.out.println(isUniqueChars2(s));
	}
}
