import java.util.Random;

public class Solution_12 {

    public static void main(String[] args) {
        int num = new Random().nextInt(8);
        System.out.println("num ==>" + num + ", intToRoman ==>" + new Solution_12().intToRoman(num));
    }


    /**
     * @param num 1 <= num <= 3999
     */
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length && num > 0; i++) {
            while (num >= value[i]) {
                sb.append(roman[i]);
                num -= value[i];
            }
        }
        return sb.toString();
    }


}
