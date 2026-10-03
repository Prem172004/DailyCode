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
    public List<Double> averageOfLevels(TreeNode root) {
       List<Double> res = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>(); 
       q.offer(root);
       while(!q.isEmpty()) {
        int size = q.size();
        double solution = 0;
        for(int i = 0; i < size; i++) {
            TreeNode n = q.poll();
            solution += n.val;
            if(n.left != null) q.offer(n.left);
            if(n.right != null) q.offer(n.right);
        }
        res.add(solution/size);
       }
       return res;
    }
}