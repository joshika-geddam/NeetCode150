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
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return check(root,root.val);
    }
    public int check(TreeNode root,int maxVal){
        if(root==null){
            return 0;
        }
        int res=(root.val>=maxVal)?1:0;
        maxVal=Math.max(root.val,maxVal);
        res+=check(root.left,maxVal);
        res+=check(root.right,maxVal);
        return res;
    }
}