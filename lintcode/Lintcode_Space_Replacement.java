//http://www.lintcode.com/en/problem/space-replacement/
public class Lintcode_Space_Replacement {
	public int replaceBlank(char[] string, int length) {
        if(string==null||length==0) return length;  //" " is valid input 
        int count=0;
        for(int i=0;i<length;i++) {
            if(string[i]==' ') count++;
        }
        int newLen=length+2*count;
        int j=length-1;
        for(int i=newLen-1;i>=0;i--) {
            if(string[j]!=' ') {
                string[i] = string[j];
            }
            else {
                string[i]='0';
                string[--i]='2';
                string[--i]='%';
            }
            j--;
        }
        return newLen;
    }
}
