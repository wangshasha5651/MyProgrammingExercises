/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/



/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public int run(TreeNode root) {
        if(root == null ){
            return 0;
        }
        int lDepth = run(root.left);
        int rDepth = run(root.right);
        if(lDepth == 0 || rDepth == 0){
            return lDepth + rDepth + 1;
        }
        return Math.min(lDepth,rDepth) + 1;
    }
}