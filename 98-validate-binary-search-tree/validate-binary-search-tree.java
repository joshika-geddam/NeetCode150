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
        List<Integer> list=new ArrayList<>();
        helper(root,list);
        boolean isValid=true;
        int prev=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=prev){
                return false;
            }
            prev=list.get(i);
        }
        return isValid;
        
    }
    public void helper(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
}