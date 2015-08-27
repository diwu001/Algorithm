//http://www.lintcode.com/en/problem/coins-in-a-line/
public class Lintcode_Coins_in_a_Line {
	 /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
	
	// n%3==0: first loses
	// e.g. n=3: first player takes 1 coin, second play takes 2 coins; first player takes 2 coin, second play takes 1 coins
    public boolean firstWillWin(int n) {
        return n%3!=0;
    }
}
