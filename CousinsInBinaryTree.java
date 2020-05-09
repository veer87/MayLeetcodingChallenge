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
 https://leetcode.com/problems/cousins-in-binary-tree/
 
 */
class Solution {
    Integer depthX;
    Integer depthY;
    TreeNode parentX;
    TreeNode parentY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        boolean isCousin = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int countDepth = 0;
        int curQSize = 1;
        while(!q.isEmpty()) {
            int i = 0;
            while(i++ < curQSize) {
                TreeNode curNode = q.remove();
                if (curNode.left != null) {
                    q.add(curNode.left);
                    if (curNode.left.val == x) {
                        parentX = curNode;
                        depthX = countDepth + 1;
                    } else if (curNode.left.val == y) {
                        parentY = curNode;
                        depthY = countDepth + 1;
                    }
                }
                
                if (curNode.right != null) {
                    q.add(curNode.right);
                    if (curNode.right.val == y) {
                        parentY = curNode;
                        depthY = countDepth + 1;
                    } else if (curNode.right.val == x) {
                        parentX = curNode;
                        depthX = countDepth + 1;
                    }
                }
            }
            countDepth++;
            curQSize = q.size();
            if (depthX != null 
                && depthY != null 
                && depthX == depthY 
                && parentX != null 
                && parentY != null
                && parentX != parentY) {
                isCousin = true;
                break;
            }
        }
        return isCousin;
    }
    
}