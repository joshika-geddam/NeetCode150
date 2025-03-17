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
    int maxValue=0;
    public int maxPathSum(TreeNode root) {
    maxValue=Integer.MIN_VALUE;
    checkSum(root);
    return maxValue;
    }
    public int checkSum(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=Math.max(0,checkSum(node.left));
        int right=Math.max(0,checkSum(node.right));
        maxValue=Math.max(maxValue,left+right+node.val);
        return Math.max(left,right)+node.val;
    }
}