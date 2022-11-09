import java.util.*;

/**
 * @link <a href="https://leetcode.com/problems/top-k-frequent-words/">...</a>
 */
public class Solution_692 {

    /**
     * Given an array of strings words and an integer k, return the k most frequent strings.
     * <p>
     * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
     * Output: ["i","love"]
     * Explanation: "i" and "love" are the two most frequent words.
     * Note that "i" comes before "love" due to a lower alphabetical order.
     * Example 2:
     * <p>
     * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
     * Output: ["the","is","sunny","day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= words.length <= 500
     * 1 <= words[i].length <= 10
     * words[i] consists of lowercase English letters.
     * k is in the range [1, The number of unique words[i]]
     */
    public static void main(String[] args) {
        String[] words = new String[]{"glarko", "zlfiwwb", "nsfspyox", "pwqvwmlgri", "qggx", "qrkgmliewc", "zskaqzwo", "zskaqzwo", "ijy", "htpvnmozay", "jqrlad", "ccjel", "qrkgmliewc", "qkjzgws", "fqizrrnmif", "jqrlad", "nbuorw", "qrkgmliewc", "htpvnmozay", "nftk", "glarko", "hdemkfr", "axyak", "hdemkfr", "nsfspyox", "nsfspyox", "qrkgmliewc", "nftk", "nftk", "ccjel", "qrkgmliewc", "ocgjsu", "ijy", "glarko", "nbuorw", "nsfspyox", "qkjzgws", "qkjzgws", "fqizrrnmif", "pwqvwmlgri", "nftk", "qrkgmliewc", "jqrlad", "nftk", "zskaqzwo", "glarko", "nsfspyox", "zlfiwwb", "hwlvqgkdbo", "htpvnmozay", "nsfspyox", "zskaqzwo", "htpvnmozay", "zskaqzwo", "nbuorw", "qkjzgws", "zlfiwwb", "pwqvwmlgri", "zskaqzwo", "qengse", "glarko", "qkjzgws", "pwqvwmlgri", "fqizrrnmif", "nbuorw", "nftk", "ijy", "hdemkfr", "nftk", "qkjzgws", "jqrlad", "nftk", "ccjel", "qggx", "ijy", "qengse", "nftk", "htpvnmozay", "qengse", "eonrg", "qengse", "fqizrrnmif", "hwlvqgkdbo", "qengse", "qengse", "qggx", "qkjzgws", "qggx", "pwqvwmlgri", "htpvnmozay", "qrkgmliewc", "qengse", "fqizrrnmif", "qkjzgws", "qengse", "nftk", "htpvnmozay", "qggx", "zlfiwwb", "bwp", "ocgjsu", "qrkgmliewc", "ccjel", "hdemkfr", "nsfspyox", "hdemkfr", "qggx", "zlfiwwb", "nsfspyox", "ijy", "qkjzgws", "fqizrrnmif", "qkjzgws", "qrkgmliewc", "glarko", "hdemkfr", "pwqvwmlgri"};
        int k = 14;
        System.out.println("words ==>" + Arrays.toString(words) + ",k ==>" + k + ", topKFrequent ==>" + new Solution_692().topKFrequent(words, k));
    }

    public List<String> topKFrequent1(String[] words, int k) {
        // 对词的计数, 区分每个词 累计出现次数
        Map<String, Integer> counter = new LinkedHashMap<>();
        for (String word : words) {
            counter.merge(word, 1, Integer::sum);
        }
        // 优先队列，如果计数不想等直接按计数大小排序，相等则按词顺序排序。
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() != o2.getValue()) {
                return o1.getValue().compareTo(o2.getValue());
            } else {
                return -o1.getKey().compareTo(o1.getKey());
            }
        });
        // 入队
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        // 出队 小 -> 大
        List<String> ans = new ArrayList<>(k);
        while (heap.size() > 0) {
            ans.add(heap.poll().getKey());
        }
        // 翻转集合
        Collections.reverse(ans);
        return ans;
    }

    public List<String> topKFrequent(String[] words, int k) {
        // 对词的计数, 区分每个词 累计出现次数
        Map<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            counter.merge(word, 1, Integer::sum);
        }
        // 优先队列，如果计数不想等直接按计数大小排序，相等则按词顺序排序。
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o2.getValue() - o1.getValue();
            }
        });
        // 入队
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            heap.offer(entry);
        }
        // 出队 大 -> 小
        List<String> ans = new ArrayList<>(k);
        for (int i = k - 1; i >= 0; i--) {
            ans.add(heap.poll().getKey());
        }
        return ans;
    }

}
