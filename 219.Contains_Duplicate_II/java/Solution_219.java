import java.util.Arrays;

public class Solution_219 {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        System.out.println("nums => " + Arrays.toString(nums) + ", k =>" + k + " ==> containsNearbyDuplicate ==> " + new Solution_219().containsNearbyDuplicate(nums, k));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // i 可以是 k 的2倍，j 也是 K的2倍
        int len = (k * k) > nums.length ? Math.min(k * k, nums.length - 1) : nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = len; j > 0; j--) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    // Time Limit Exceeded
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        // i 可以是 k 的2倍，j 也是 K的2倍
        int len = (k * k) > nums.length ? Math.min(k * k, nums.length - 1) : nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = len; j > 0; j--) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    // Time Limit Exceeded
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
