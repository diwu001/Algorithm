/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
  If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
  The replacement must be in-place, do not allocate extra memory.
  Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1*/

import java.util.Arrays;

public class Next_Permutation {
	public void nextPermutation(int[] num) {
        int n = num.length;
        if(n<=1) return;
        int i=n-2;
        for(;i>=0;i--) {
            if(num[i]<num[i+1]) break;
        }
        if(i==-1) {
            Arrays.sort(num);
            return;
        }
        
        int j=n-1;
        for(;j>i;j--) {
            if(num[j]>num[i]) break;
        }
        
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        
        for(int k=i+1,l=n-1;k<l;k++,l--) {
            temp = num[k];
            num[k] = num[l];
            num[l] = temp;
        }
    }
}
