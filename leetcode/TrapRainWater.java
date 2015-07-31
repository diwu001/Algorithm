
public class TrapRainWater {
    //Time O(n), Space O(1)
    int getIndexOfMaxElement(int[] A) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < A.length; i++) { // max height in A
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
      
    int trap(int[] A) {
        if(A==null||A.length<2) return 0;
        int n=A.length;
        // Finds the index with maximum height
        int maxIndex = getIndexOfMaxElement(A);
    
        // Calculates the water within [1 : maxIndex - 1]
        int sum = 0, left = A[0];
        for (int i = 1; i < maxIndex; ++i) {
            if (A[i] >= left) {
                left = A[i];
            } else {
                sum += left - A[i];
            }
        }
    
        // Calculates the water within [maxIndex + 1 : n - 2]
        int right = A[n-1];
        for (int i = n - 2; i > maxIndex; --i) {
            if (A[i] >= right) {
                right = A[i];
            } else {
                sum += right - A[i];
            }
        }
		
        return sum;
    }
	
    //Time O(n), Space O(n)
    int trap2(int[] A) {
        int n = A.length;
        if(n <= 2) return 0;
        int sum = 0;
        
        int[] left = new int[n];
        int[] right =new int[n];
        
        left[0] = A[0];
        for(int i = 1; i < n - 1; i++) {
            left[i] = Math.max(A[i], left[i - 1]);
        }
        
        right[n - 1] = A[n - 1];
        for(int i = n - 2; i > 0; i--) {
            right[i] = Math.max(A[i], right[i + 1]);
        }
        
        for(int i = 1; i <n - 1; i++) {
            sum += (Math.min(left[i], right[i]) - A[i]);
        }
        
        return sum;
    }
}
