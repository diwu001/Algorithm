//http://www.lintcode.com/en/problem/update-bits/
public class Lintcode_Update_Bits {
	// Given N=(10000000000)2, M=(10101)2, i=2, j=6  return N=(10001010100)2
	public int updateBits(int n, int m, int i, int j) {
        int l=j-i+1;  //i=2, j=6 l=5
        int mask= (l==32)? 0xffffffff : (1<<l)-1;  //100000-1 => 011111 as mask
        return (n&~(mask<<i)) | ((m&mask)<<i);  // set corresponding bits in n to be 0, and then set it to be the bits in m
    }
}
