
public class AddDigits {
	int addDigits(int num) {
        if(num <= 9) return num;
        int result = num % 9;
        return result == 0 ? 9 : result;
    }
}
