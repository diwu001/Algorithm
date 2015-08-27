// Given a string, such as "orange red   delicious  " and an integer n, Return first n chars of words. There may be many spaces in the input string.
// n=1, return empty; n=6 or n = 9 return "orange"; n=10 return "orange red";   n=100 return "orange red delicious"

public class Words_in_first_n_chars {
	public static String printWords(String s, int n) {
		if(s==null||s.length()==0) return "";
		StringBuilder sb = new StringBuilder();
		int k=0, len=s.length(), i=0, j=0;
		while(k<len){
			if(s.charAt(k)!=' ') {
				i=k;
				j=k;
				while(j+1<len && s.charAt(j+1)!=' ') j++;
				if(j+1<=n) sb.append(s.substring(i,j+1));
				else break;
				k=j+1;
			} else k++;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s="orange red   delicious  ";
		int[] test = {0,1,6,9,10,100};
		for(int i=0;i<test.length;i++) 
			System.out.println("n=" +test[i]+" :"+printWords(s,test[i]));
	}
}
