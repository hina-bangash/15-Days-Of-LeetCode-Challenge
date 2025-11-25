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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       
        // both empty → same
        if (p == null && q == null) return true;

        // one empty, one not → not same
        if (p == null || q == null) return false;

        // values mismatch → not same
        if (p.val != q.val) return false;

        // recurse on left and right
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    
    }
}