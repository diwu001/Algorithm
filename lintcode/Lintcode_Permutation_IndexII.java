//http://www.lintcode.com/en/problem/permutation-index-ii/
/*Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers, 
which are ordered in lexicographical order. The index begins at 1. Given the permutation [1, 4, 2, 2], return 3*/

import java.util.TreeMap;
import java.util.HashMap;
public class Lintcode_Permutation_IndexII {
    // Time:  O(n^2) Space: O(n)
    public long permutationIndexII(int[] A) {
	long index = 1, factor = 1;
        int position = 2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(A[A.length-1],1);
        for (int i = A.length - 2; i >= 0; --i) {
            if(!map.containsKey(A[i])) map.put(A[i],1);
            else map.put(A[i],map.get(A[i])+1);
            HashMap<Integer, Integer> suc = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < A.length; ++j) {
                if (A[i] > A[j]) {
                	if(!suc.containsKey(A[j])) suc.put(A[j],1);
                    else suc.put(A[j],suc.get(A[j])+1);
                }
            }
            for (Integer num : suc.keySet()) {
                index += factor * suc.get(num) / map.get(A[i]);
            }
            factor = factor * position / map.get(A[i]);
            ++position;
        }
        return index;
    }
	
    // Time:  O(n^2) Space: O(n)
    public long permutationIndexII_2(int[] A) {
        long index = 1, factor = 1;
        int position = 2;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        // Use treemap, for A[i], all the possible A[j]<A[i], j>i can be found at the front of treemap 
        map.put(A[A.length-1],1);
        for (int i = A.length - 2; i >= 0; --i) {
            if(!map.containsKey(A[i])) map.put(A[i],1);
            else map.put(A[i],map.get(A[i])+1);
            for (Integer key : map.keySet()) {
                if (key >= A[i]) {
                    break;
                } 
                index += factor * map.get(key) / map.get(A[i]);
            }
            factor = factor * position / map.get(A[i]);
            ++position;
        }
        return index;
    }
}
