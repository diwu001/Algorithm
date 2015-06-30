//http://www.lintcode.com/en/problem/flip-bits/
public class Lintcode_Flip_Bits {
	public static int bitSwapRequired(int a, int b) {
        if(a==b) return 0;
        int count=0;
        for(int i=0;i<32;i++) {
            int digit = ((a>>i)&1) ^ ((b>>i)&1);  //If the corresponding bit in a / b differs, count++
            count+=digit;
        }
        return count;
    }
//--------------------------------------------------
	public static int bitSwapRequired2(int a, int b) {
        if(a==b) return 0;
        int count=0;
        int xor = a^b;
        for(int i=0;i<32&xor!=0;i++) {
            count += (xor&1);
            xor=xor>>1;
        }
        return count;
    }
}
