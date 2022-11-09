import java.util.ArrayList;
import java.util.List;

/**
 * Todo
 */
public class Solution_1239 {

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("dx");
        arr.add("ey");
        arr.add("am");
        arr.add("bn");
        arr.add("abc");
        arr.add("def");

        System.out.println("arr ==>" + arr + ", maxLength ==>" + new Solution_1239().maxLength(arr));

        String a = "aefbc";
        String b = "afferqafa";
        System.out.println(a.contains(b));
    }

    /**
     * 关键信息一、字符组成一个字母不重复的最大长度字符
     * 关键信息二、可以通过删除一些元素不能改变元素的顺序
     * 关键信息三、每个元素都没有重复的字母，如果有重复的则不能参与计算
     * 个人理解：一个元素中的字符，和需要拼接的元素不能有重复的字母，取最大长度拼接元素
     * 如果元素只有一个直接返回长度即可。
     * <p>
     * 信息定义：
     * 1 <= arr.length <= 16
     * 1 <= arr[i].length <= 26
     * arr[i] contains only lowercase English letters.
     *
     * @param arr 每个元素中都没有重复字母 alphabet
     */
    public int maxLength(List<String> arr) {
        boolean flag;
        int[] alphabet;
        List<String> ans = new ArrayList<>();
        for (String s : arr) {
            flag = true;
            alphabet = new int[26];
            int size = ans.size();
            // 过滤重复单词字符串
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int n = alphabet[chars[i] - 96];
                if (n > 0) {
                    flag = false;
                    break;
                }
                alphabet[chars[i] - 96]++;
            }
            if (!flag) {
                continue;
            }
            if (size == 0) {
                ans.add(s);
            }else{
                for (int i = 0; i < size; i++) {
                    String word = ans.get(i);

                }
            }
        }

        // 找出一个最大length的元素
        int max = 0;
        for (String an : ans) {
            max = Math.max(max, an.length());
        }

        return max;
    }
}
