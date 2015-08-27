
public class Count_Prime {
    public int countPrimes(int n) {
        if(n<=3) return n;
        int count=0;
        boolean flag=false;
        while(n>4) {
            for(int i=2;i<=n/2;i++) {
                if(n/i==0) flag=true;
            }
            if(!flag) count++;
            n--;
        }
        return count+3;
    }
    
    public int countPrimes2(int n) {
        boolean[] dp=new boolean[n+1];//true means not a prime
        dp[0]=true; //not a prime
        if(n==0) return 0; //check input
        dp[1]=true;
        for(int i=2;i*i<n;i++) {
           if(!dp[i]) {
               int temp=i*i;
               dp[temp]=true;
               while(temp+i<n) {
                   temp+=i;
                   dp[temp]=true;
               }
           }
        }
        int sum=0;
        for(int i=0;i<n;i++) {
            if(!dp[i]) sum++;
        }
        return sum;
    }
}
