/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/3 ⌋ times. 
 * You may assume that the array is non-empty and the majority element always exist in the array.*/

package majority_numberII;

import java.util.ArrayList;

public class Lintcode_Majority_NumberII {
	public static int majorityNumber(ArrayList<Integer> nums) {
		int count1=0,count2=0,can1=Integer.MIN_VALUE,can2=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++) {
            if (can1==nums.get(i)) count1++;
            else if (can2==nums.get(i)) count2++;
            else if (count1==0) {
                can1 = nums.get(i);
                count1++;
            } else if(count2==0) {
                can2 = nums.get(i);
                count2++;
            } else {count1--; count2--;}
            
        }
        
        count1=0;
        count2=0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==can1) count1++;
            else if(nums.get(i)==can2) count2++;
            else continue;
        }
        return (count1>count2)? can1:can2;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(99);
		nums.add(2);
		nums.add(99);
		nums.add(2);
		nums.add(99);
		nums.add(3);
		nums.add(3);
		System.out.print(majorityNumber(nums));
	}
}
//[1,1,1,1,2,2,3,3,4,4,4] wrong4 corret 1
