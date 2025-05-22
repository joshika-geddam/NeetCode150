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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxSum=Integer.MIN_VALUE;
        check(root);
        return maxSum;
    }
    public int check(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(check(root.left),0);
        int right=Math.max(check(root.right),0);
        maxSum=Math.max(maxSum,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}