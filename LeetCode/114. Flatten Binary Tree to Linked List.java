/**
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode head = new TreeNode(0);
        Stack<TreeNode> sk = new Stack<TreeNode>();
        sk.push(root);
        while(!sk.isEmpty()){
            TreeNode node = sk.pop();
            head.right = node;
            head.left = null;
            if(node.right != null){
                sk.push(node.right);
            }
            if(node.left != null){
                sk.push(node.left);
            }
            head = node;
        }
    }