import java.util.Random;

public class Solution_278 {

    int bad_version = 4;

    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public boolean isBadVersion(int version) {
        return version <= bad_version;
    }
}
