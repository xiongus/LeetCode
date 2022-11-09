import java.util.LinkedList;

public class Solution_21 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode res = mergeTwoLists(list1, list2);
        StringBuilder sb = new StringBuilder();
        while (res != null) {
            sb.append(res.val).append("->");
            res = res.next;
        }
        System.out.println(sb);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode pre = new ListNode(-1), last = pre;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                last.next = list2;
                list2 = list2.next;
            } else {
                last.next = list1;
                list1 = list1.next;
            }
            last = last.next;
        }
        last.next = list1 != null ? list1 : list2;
        return pre.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode pre = new ListNode(-1);
        ListNode next;
        while (list1 != null && list2 != null) {
            ListNode cur = pre;
            while (cur.next != null) {
                cur = cur.next;
            }
            if (list1.val >= list2.val) {
                next = new ListNode(list2.val);
                list2 = list2.next;
                if (list2 == null) {
                    next.next = list1;
                }
            } else {
                next = new ListNode(list1.val);
                list1 = list1.next;
                if (list1 == null) {
                    next.next = list2;
                }
            }
            cur.next = next;
        }
        return pre.next;
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
