//http://www.lintcode.com/en/problem/partition-array-by-odd-and-even/
// partition in quick sort [1, 2, 3, 4] => [1, 3, 2, 4], Time O(n), in-place
public class Lintcode_Partition_Array_by_Odd_and_Even {
    // Solution 1
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
    
    // Solution 2
    public void partitionArray2(int[] nums) {
        if(nums==null||nums.length<=1) return;
        int n=nums.length,i=0,j=n-1;
        while(i<j) {
            while(i<j&&nums[i]%2==1) i++;
            while(i<j&&nums[j]%2==0) j--;
            if(i<j) {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
        }
    }
}
