import java.util.LinkedList;

public class Solution_110 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("root -->" + root + ", isBalanced ==> " + new Solution_110().isBalanced(root));
    }

    // 解题思路：计算左子树和右子数的深度差是否大于1
    // 遗忘思路：如果左子树和右子树<=1 还需要计算 左子树中的高度，右子树中的高度
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int depth(TreeNode node) {
        int l, r;
        if (node == null) return 0;
        l = depth(node.left);
        r = depth(node.right);
        return r > l ? r + 1 : l + 1;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            LinkedList<TreeNode> queues = new LinkedList<>();
            queues.offer(this);
            while (!queues.isEmpty()) {
                TreeNode node = queues.poll();
                sb.append(node.val).append(",");
                if (node.left != null) {
                    queues.offer(node.left);
                }
                if (node.right != null) {
                    queues.offer(node.right);
                }
            }
            return "[" + sb.substring(0, sb.length() - 1) + "]";
        }
    }

}
