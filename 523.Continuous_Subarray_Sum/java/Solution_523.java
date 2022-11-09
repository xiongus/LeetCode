import java.util.*;

public class Solution_523 {

    public static void main(String[] args) {
        int[] nums = {2,4,3};
        int k = 6;
        System.out.println(
                "nums ==>" + Arrays.toString(nums)
                        + ", k ==>" + k
                        + ", checkSubarraySum ==>" + new Solution_523().checkSubarraySum(nums, k));
    }

    /**
     *
     * ①一个整数能够被另一个整数整除，这个整数就是另一整数的倍数。如15能够被3或5整除，因此15是3的倍数，也是5的倍数。
     * ②一个数除以另一数所得的商。如a÷b=c，就是说，a是b的倍数。例如：A÷B=C，就可以说A是B的C倍。
     * ③一个数的倍数有无数个，也就是说一个数的倍数的集合为无限集。 注意：不能把一个数单独叫做倍数，只能说谁是谁的倍数。
     *
     * 数组可以分为 一个大于K的，一个小于K的
     * 大于k的 可以用来除以k得到k的倍数 在集合中是否存在
     * 小于k的，可以用来2数相加=k 也就是用 |i - k| 在集合是否存在
     *
     * @param nums 没有负数
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 累加数据
            sum += nums[i];
            // 得出余数
            sum %= k;
            // 如果已经整除并且i大于1(至少2个连续要求)
            if (sum == 0 && i > 0) {
                return true;
            }
            // 得出来的余数匹配是否已经存在，如果存在则可以理解为 从存在的下标+1 -> 当前下标之间是可以得出k整除的数
            // i - map.get(sum) > 1 至少2个连续要求，避免2个数之后的一个值能够匹配结果
            if (map.containsKey(sum) && i - map.get(sum) > 1) {
                return true;
            }
            // 保留每次都有余数的下标值
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return false;
    }
}
