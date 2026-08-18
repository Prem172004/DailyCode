class Solution {
    int solveWithMemo(int n, int[] memo) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (memo[n] != -1)
            return memo[n];

        int pick = solveWithMemo(n - 2, memo);
        int not = solveWithMemo(n - 1, memo);

        memo[n] = pick + not;

        return memo[n];
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solveWithMemo(n, memo);
    }
}