import com.sun.jmx.remote.internal.ArrayQueue;
import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
 }

public class Main {
    public String serialize(TreeNode root) {
        if(root == null ){
            return "#";
        }
        StringBuilder serialRet = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root != null){
            queue.add(root);
            TreeNode out = queue.element();
            serialRet.append(out.val);
            serialRet.append(',');
        }

        while(!queue.isEmpty()) {
            TreeNode out = queue.poll();
            if(out != null){
                if(out.left == null){
                    serialRet.append('#');
                }else{
                    serialRet.append(out.left.val);
                }
                serialRet.append(',');
                if(out.right == null){
                    serialRet.append('#');
                }else{
                    serialRet.append(out.right.val);
                }
                serialRet.append(',');
            }
            if(out.left != null){
                queue.add(out.left);
            }
            if(out.right != null){
                queue.add(out.right);
            }
        }
        String ret = serialRet.toString();
        ret = ret.substring(0, ret.length()-1);
        return ret;
    }
    public TreeNode deserialize(String data) {

        String[] str = data.split(",");
        if(str.length == 0 || data.equals("#")){
            TreeNode rootNull = null;
            return rootNull;
        }
        Queue<TreeNode> queue2 = new ArrayDeque<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue2.add(root);
        int i = 1;
        while(!queue2.isEmpty() && i < str.length){
            TreeNode node = queue2.poll();
            if(str[i].equals("#")){
                node.left = null;
                i++;
            }else{
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue2.add(node.left);
                i++;
            }

            if(i < str.length && str[i].equals("#")){
                node.right = null;
                i++;
            }else if(i < str.length && !str[i].equals("#")){
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue2.add(node.right);
                i++;
            }

        }
        return root;
    }

}
