//http://www.lintcode.com/en/problem/o1-check-power-of-2/
public class Lintcode_Check_Power_of_2 {
	 /*
     * @param n: An integer
     * @return: True or false
     */
	
	// bit operation
	// n&(n-1) can set the lowest bit of 1 in n to be 0. 
	// 100 & 011 => 000, so 100 is the power of 2 
	// 101 & 100 => 100, so 101 isn't the power of 2
    public boolean checkPowerOf2(int n) {
        if(n==0||n==Integer.MIN_VALUE) return false;
        return (n&(n-1))==0 ? true: false;
    }
}
