public class Solution_226 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);
        System.out.println(node.toString());

        System.out.println(new Solution_226().invertTree(node));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
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
            StringBuilder sb = new StringBuilder("[");
            TreeNode root = this;
            sb.append(root.val);
            LoopToString(root, sb);
            sb.append("]");
            return sb.toString();
        }

        // 排序 - 前序
        // 排序 - 中序
        // 排序 - 后序

        private void LoopToString(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            if (root.left != null) {
                sb.append(",").append(root.left.val);
            }
            if (root.right != null) {
                sb.append(",").append(root.right.val);
            }
            LoopToString(root.left, sb);
            LoopToString(root.right, sb);
        }
    }
}
