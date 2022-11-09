import java.util.LinkedList;

public class Solution_235 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

//        System.out.print("前序遍历：");
//        new Solution_235().preOrder(root);
//        System.out.println();
//        System.out.print("中序遍历：");
//        new Solution_235().inOrder(root);
//        System.out.println();
//        System.out.print("后序遍历：");
//        new Solution_235().postOrder(root);
//        System.out.println();
//        System.out.print("层次遍历：");
//        new Solution_235().levelOrder(root);
//        System.out.println();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(3);
        System.out.println(new Solution_235().lowestCommonAncestor(root, p, q));

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            new Solution_235().levelOrder(this);
            return "";
        }


        private void mid(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(",").append("null");
                return;
            }
            sb.append(",").append(root.val);
            if (root.left != null) {
                sb.append(",").append(root.left.val);
            }
            if (root.right != null) {
                sb.append(",").append(root.right.val);
            }
            mid(root.left, sb);
            mid(root.right, sb);
        }
    }

    //DLR 前序遍历：根结点 ---> 左子树 ---> 右子树
    public void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + "-->");
        preOrder(node.left);
        preOrder(node.right);
    }

    //LDR 中序遍历：左子树---> 根结点 ---> 右子树
    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + "-->");
        inOrder(node.right);
    }

    //LRD 后序遍历：左子树 ---> 右子树 ---> 根结点
    public void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "-->");
    }

    // 层次遍历：只需按层次遍历即可
    public void levelOrder(TreeNode node) {
        if (node == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + "-->");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }
}
