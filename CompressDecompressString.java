/* Compress "aaaaabcccaa"to "a4b1c3a2"; Decompress "a4b1c3a2" to  "aaaaabcccaa"*/
public class CompressDecompressString_ {
	String compress(String s) {
		int n=s.length(), i=1, count=1;
		StringBuilder sb = new StringBuilder();
		while(i<=n) {
			if(i<n && s.charAt(i)==s.charAt(i-1)) count++;
			else { // i==n or s[i]!=s[i-1]
				sb.append(s.charAt(i-1)).append(count);
				count=1;
			}
			i++;
		}
		
		return sb.toString();
	}
	
	String decompress(String s) {
		int n=s.length(), i=0, count=0;
		StringBuilder sb = new StringBuilder();
		char pre = ' ';
		while(i<=n) {
			if(i<n && s.charAt(i)>='0' && s.charAt(i)<='9') {
				count = count*10+s.charAt(i)-'0';
			} else {
				while(count>0) {
					sb.append(pre);
					count--;
				}
				if(i<n) pre = s.charAt(i);
			}
			i++;
		}
		
		return sb.toString();
	}
}
