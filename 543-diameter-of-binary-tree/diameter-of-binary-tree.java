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
    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        HashMap<TreeNode,Integer> map=new HashMap<>();
        int diameter=0;
        if(root!=null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            if(node.left!=null && !map.containsKey(node.left)){
                stack.push(node.left);
            }
            else if(node.right!=null && !map.containsKey(node.right)){
                stack.push(node.right);
            }
            else{
                stack.pop();
                int left=map.getOrDefault(node.left,0);
                int right=map.getOrDefault(node.right,0);
                map.put(node,1+Math.max(left,right));
                diameter=Math.max(diameter,left+right);
            }
        }
        return diameter;
        
    }
}