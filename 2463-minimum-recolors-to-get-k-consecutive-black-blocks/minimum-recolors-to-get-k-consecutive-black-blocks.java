class Solution {
    public int minimumRecolors(String blocks, int k) {
        int b = 0, w = 0;
        int left = 0;
        int minOps = Integer.MAX_VALUE;

        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'B') b++;
            else w++;

            if (i - left + 1 > k) {
                if (blocks.charAt(left) == 'B') b--;
                else w--;
                left++;
            }

            if (i - left + 1 == k) {
                minOps = Math.min(minOps, w);
            }
        }

        return minOps;
    }
}