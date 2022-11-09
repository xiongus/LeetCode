public class Solution_141 {

    public static void main(String[] args) {
        ListNode node = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        System.out.println(new Solution_141().hasCycle(node));
    }

    public boolean hasCycle(ListNode head) {
        // 如果不满足2个元素，则无法组成周期
        if (head == null || head.next == null) return false;
        ListNode first = head, next = head.next;
        while (first != null && next != null) {
            if (first == next) return true;
            first = first.next.next;
            next = next.next;
        }
        return false;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
