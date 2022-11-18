public class Solution_70 {

    public int climbStairs(int n) {
        int c1 = n % 2;
        int c2 = n / 2;
        return c2 * c2 + c1;
    }

    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int[] mem = new int[n];
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_70().climbStairs(3));
    }
}
