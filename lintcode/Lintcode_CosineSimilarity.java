public class Lintcode_CosineSimilarity {
	public double cosineSimilarity(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if(m != n || m == 0) return 2.0000;
        double result = 0.0;
        for(int i = 0; i < n; i++) {
            result += A[i] * B[i];
        }
        double temp1 = 0.0, temp2 = 0.0;
         for(int i = 0; i < n; i++) {
            temp1 += (A[i] * A[i]);
            temp2 += (B[i] * B[i]);
        }
        if(temp1 == 0 || temp2 == 0) return 2.0000;
        result = result / (Math.sqrt(temp1) * Math.sqrt(temp2));
        return result;
    }
}
