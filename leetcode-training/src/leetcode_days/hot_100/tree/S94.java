package leetcode_days.hot_100.tree;

import leetcode_days.data_struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class S94 {
    public void addNode(List<Integer> res,TreeNode node){
        if(node!=null){
            addNode(res,node.left);
            res.add(node.val);
            addNode(res,node.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        addNode(res,root);
        return res;
    }
}
