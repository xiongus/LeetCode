import java.util.Arrays;

public class Solution_704 {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println("nums ==>" + Arrays.toString(nums) + ", target ==>" + target + ", search ==> " + new Solution_704().search(
                nums, target
        ));
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int val = nums[mid];
            if (val < target) {
                low = mid + 1;
            } else if (val > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}
