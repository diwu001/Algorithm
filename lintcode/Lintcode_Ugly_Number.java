//http://www.lintcode.com/en/problem/ugly-number/
import java.util.PriorityQueue;
public class Lintcode_Ugly_Number {
	public long kthPrimeNumber(int k) {   //O(K log K) time
        if(k<=0) return 0;
        PriorityQueue<Long> pq=new PriorityQueue<Long>();
        pq.offer((long)3);
        pq.offer((long)5);
        pq.offer((long)7);
        long ugly=0;
        for(int i=0;i<k;i++) {
            long temp = pq.poll();
            ugly=temp;
            if(temp%3==0) {
                pq.offer((long)temp*3);
            } else if(temp%5==0) {
                pq.offer((long)temp*3);
                pq.offer((long)temp*5);
            } else {
                pq.offer((long)temp*3);
                pq.offer((long)temp*5);
                pq.offer((long)temp*7);
            }
        }
        return ugly;
    }
		
	//-----------------------------------------------
	public long kthPrimeNumber2(int k) {  //O(K) time
        if(k<=0) return 0;
        long[] dp = new long[k+1];
        int i3=0,i5=0,i7=0;
        long mul3=3,mul5=5,mul7=7;
        long next=1;
        dp[0]=1;
        for(int i=1;i<=k;i++) {
            next = Math.min(mul3,Math.min(mul5,mul7));
            dp[i]=next;
            if(next==mul3) {
                i3++;
                mul3 = dp[i3]*3;
            }
            if(next==mul5) {
                i5++;
                mul5 = dp[i5]*5;
            }
            if(next==mul7) {
                i7++;
                mul7 = dp[i7]*7;
            }
        }
        return next;
    }
}
