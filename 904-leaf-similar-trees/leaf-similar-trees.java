class Solution {

    void solve(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        solve(root.left, leaves);
        solve(root.right, leaves);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        solve(root1, leaves1);
        solve(root2, leaves2);

        return leaves1.equals(leaves2);
    }
}
