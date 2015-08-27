//http://www.lintcode.com/en/problem/triangle-count/
//Given [3,4,6,7], return 3.  [3,4,6]  [3,6,7]  [4,6,7]
import java.util.Arrays;
public class Lintcode_Triangle_Count {
	public int triangleCount(int S[]) {
        if(S==null||S.length<3) return 0;
        Arrays.sort(S);
        int n=S.length;
        int count=0;
        for(int k=n-1;k>=2;k--) {
            int i=0,j=k-1;
            while(i<j) {
                if(S[j]+S[i]<=S[k]) {  // S[j]+S[i] is too small, can't be a triangle with S[k], so needs to increase S[i]
                   i++;
                } else {
                    count+=j-i;   //for a specific j, if S[j]+S[i]>S[k], it means that all indexes in [i~j-1] can match with j,k, new count number is j-i
                    j--;
                }
            }
        }
        return count;
    }
}
