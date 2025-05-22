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
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        List<Integer> list=new ArrayList<>();
        inorder(list,root);
        int prev=list.get(0);
        boolean isValid=true;
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=prev){
                return false;
            }
            prev=list.get(i);
        }
        return isValid;
        
    }
    public void inorder(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
}