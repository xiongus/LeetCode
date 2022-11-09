import java.util.*;

public class Solution_1 {


    public static void main(String[] args) {
        int[] nums = {2, -7, 11, 15, 16};
        int target = 9;
        System.out.println("nums==>" + Arrays.toString(nums)
                + ", target ==>" + target
                + ", twoSum ==>" + Arrays.toString(new Solution_1().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.get(val) == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(val), i};
            }
        }
        return null;
    }

}
