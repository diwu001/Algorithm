/*Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, 
which are ordered in lexicographical order. The index begins at 1. Given [1,2,4], return 1*/
public class Lintcode_Permutation_Index {
	//factor is the size of current group, position*factor is the group size of next iteration
	// A[]= {d,b,a}, initially for {a}, 'a' has the index of 0 for {a} (base 0);
	// then we consider {b,a}, i points to 'b', factor=1, suc=1, index=1, means 'b' is index 1 of {a,b};
	// then we consider {d,b,a}, i points to 'd', factor=2, suc=2, index=4, means the index of 'd' is 4, and there are 2 groups of size 2 ahead of 'd'
	// group 0 {a,b,d} {a.d,b} ; group 1 {b,a,d} {b,d,a} ; group 2{d,a,b} {d,b,a}
	public long permutationIndex(int[] A) {
        if(A==null || A.length==0) return 0;
        int n=A.length, position=2;
        long factor=1, index=0;
        for(int i=n-2;i>=0;i--) {
            int suc=0;
            for(int j=i+1;j<n;j++) {
                if(A[i]>A[j]) suc++;
            }
            index+=suc*factor;
            factor*=position;
            position++;
        }
        return index+1;
    }
}
