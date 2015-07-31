/* There are N children standing in a line. Each child is assigned a rating value.
   You are giving candies to these children subjected to the following requirements:
   1 Each child must have at least one candy.
   2 Children with a higher rating get more candies than their neighbors.
   What is the minimum candies you must give? */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Candy {
    // Solution 1: O(nlgn), Space O(n)
    class Wrapper {
        int index, val;
        Wrapper(int index, int val) {this.index=index; this.val=val;}
    }
    
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0) return 0;
        int n=ratings.length, sum=0;
        Comparator<Wrapper> c = new Comparator<Wrapper>(){
            public int compare(Wrapper w1, Wrapper w2) {
                return w1.val-w2.val;
            }  
        };
        PriorityQueue<Wrapper> minHeap = new PriorityQueue<Wrapper>(1, c);
        for (int i = 0; i < n; i++) {
            minHeap.add(new Wrapper(i, ratings[i]));
        }
    
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        while (!minHeap.isEmpty()) {
            int nextDev = minHeap.poll().index;

            if (nextDev > 0) {  //Compare with left neighbor
                if (ratings[nextDev] > ratings[nextDev - 1]) {
                    candies[nextDev] = candies[nextDev - 1] + 1;
              }
            }

            if (nextDev + 1 < n) {  //Compare with right neighbor
                if (ratings[nextDev] > ratings[nextDev + 1]) {
                    candies[nextDev] = Math.max(candies[nextDev], candies[nextDev + 1] + 1);
                }
            }
        }
        for(int num:candies) sum+=num;
        return sum;
    }
	
    // Solution 2: O(n), Space O(n)
    public static int candy2(int[] ratings) {
        int n = ratings.length;
        if(n==0) return 0;
        int sum = 0;
        int[] num = new int[n];
        for(int i=1;i<n;i++) {
        	if (ratings[i-1]<ratings[i]) num[i]=num[i-1]+1;  		        	
        }
        for(int i=n-1;i>0;i--) {
        	if (ratings[i-1]>ratings[i]&&num[i-1]<=num[i]) num[i-1]=num[i]+1;   
        }
        for(int i=0;i<n;i++) sum+=num[i];
        return sum+n;
    }
}
