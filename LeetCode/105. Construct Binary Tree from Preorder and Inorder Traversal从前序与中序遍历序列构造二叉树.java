

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        TreeNode root = constructTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    public TreeNode constructTree(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright){
        if(pleft > pright || ileft > iright){
            return null;
        }
        int rootValue = preorder[pleft];
        TreeNode root = new TreeNode(rootValue);

        int rindex = findRoot(inorder, ileft, iright, rootValue);
        int leftTreeLen = rindex - ileft;

        root.left = constructTree(preorder, pleft + 1, pleft + leftTreeLen, inorder, ileft, rindex-1);
        root.right = constructTree(preorder, pleft + leftTreeLen + 1, pright, inorder, rindex + 1, iright);

        return root;
    }
    public int findRoot(int[] inorder, int left, int right, int center){
        int i;
        for (i = left; i <= right; i++) {
            if(inorder[i] == center)
                break;
        }
        return i;
    }