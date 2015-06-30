//http://www.lintcode.com/en/problem/partition-array-by-odd-and-even/http://www.lintcode.com/en/problem/partition-array-by-odd-and-even/
public class Lintcode_Partition_Array_by_Odd_and_Even {
	// partition in quick sort [1, 2, 3, 4] => [1, 3, 2, 4]
	public void partitionArray(int[] nums) {
        if(nums==null||nums.length<=1) return;
        int i=0,j=0;
        while(j<nums.length) {
            if(nums[j]%2!=0) {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;  // i keeps pointing to the first even number
                j++;
            } else {
                j++;
            }
        }
    }
}
