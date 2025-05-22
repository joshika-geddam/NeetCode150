/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String fullTree=pre(root);
        String subTree=pre(subRoot);
        return fullTree.contains(subTree);
    }
    public String pre(TreeNode node){
        if(node==null){
            return "null";
        }
        StringBuilder sb=new StringBuilder("^");
        sb.append(node.val);
        sb.append(pre(node.left));
        sb.append(pre(node.right));
        return sb.toString();
    }
}