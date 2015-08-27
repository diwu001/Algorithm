/*二进制操作。效率最高，时间O(1)空间O(1)。因为4次幂其实就是特殊的2次幂，即是1每次往左移两位。
比如前四个4次幂数字如下：
1 = 0b000000001
4 = 0b000000100
16 = 0b000010000
64 = 0b001000000*/
public class Powerof4 {
	public static void main(String[] args) {
		int x=8;
		boolean result = ( ((x&0xAAAAAAAA)==0) && ((x&(x-1))==0) );
		System.out.println(result);
	}
}
