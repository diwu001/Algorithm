//http://www.lintcode.com/en/problem/subarray-sum-closest/
// Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
// e.g. Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]   
// O(nlogn) time

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class Lintcode_Subarray_Sum_Closest {
	class Pair{
        int index, val;
        public Pair(int index, int val){
            this.index=index;
            this.val=val;
        }
    }
    public ArrayList<Integer> subarraySumClosest(int[] nums) {  //O(nlogn)
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums==null||nums.length==0) return result;
        result.add(0);
        result.add(0);
        int n=nums.length;
        if(n==1) return result;
        Pair[] preSum = new Pair[n];
        preSum[0]=new Pair(0,nums[0]);
        for(int i=1;i<n;i++) {
            preSum[i]=new Pair(i,preSum[i-1].val+nums[i]);  // nums[0]+.. +nums[i]
        }
        Comparator<Pair> c = new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.val-p2.val;
            }  
        };
        Arrays.sort(preSum,c);  //sort presum[] array in ascending order
        
        int minDif = Math.abs(preSum[1].val-preSum[0].val);
        result.set(0,Math.min(preSum[0].index,preSum[1].index)+1);
        result.set(1,Math.max(preSum[0].index,preSum[1].index));
        
        for(int i=1;i<n;i++) {  //compare the difference of adjacent preSum[i-1] and preSum[i] to find the min |diff|
            if(Math.abs(preSum[i].val-preSum[i-1].val)<minDif) {
                minDif=Math.abs(preSum[i].val-preSum[i-1].val);
                result.set(0,Math.min(preSum[i-1].index,preSum[i].index)+1);
                result.set(1,Math.max(preSum[i-1].index,preSum[i].index));
            }
        }
        return result;
    }
}
