/* Swap odd and even bits in an integer with as few instructions as possible (bit 0 swap with bit 1, bit 2 swap with bit 3)
 x&0xAAAAAAAA get even digits and move to odd digits; x&0x55555555 get odd digits and move to even digits */
public class SwapOddEvenBits_5_6 {
	public static void main(String[] args) {
		int x=6;
		int result = ( ((x&0xAAAAAAAA)>>1) | ((x&0x55555555)<<1) );
		System.out.println(result);
	}
}
