//http://www.lintcode.com/en/problem/a-b-problem/
public class Lintcode_A_Plus_B_Problem {
	/*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
	
	// bit operation 
	// 0&0=0 0&1=0 1&0=0 1&1=1 -> a&b can generate all carry at each bit position
	// 0^0=0 0^1=1 1^0=1 1^1=0 -> a^b can generate all sum result at each bit position without carry
	// firstly get a+b at each bit by a^b without carry, then use b=carry<<1 to prepare for next carry
	public int aplusb(int a, int b) {
        if(a==0) return b;
        if(b==0) return a;
        while(b!=0) {
            int carry = a&b;
            a=a^b;  
            b=carry<<1;
        }
        return a;
    }
}
