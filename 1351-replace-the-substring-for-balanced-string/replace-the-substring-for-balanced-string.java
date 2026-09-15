class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;

        int[] count = new int[4];

        for (char ch : s.toCharArray()) {
            if (ch == 'Q')
                count[0]++;
            else if (ch == 'W')
                count[1]++;
            else if (ch == 'E')
                count[2]++;
            else if (ch == 'R')
                count[3]++;
        }

        if (count[0] == target &&
                count[1] == target &&
                count[2] == target &&
                count[3] == target) {
            return 0;
        }

        int left = 0;
        int ans = n;

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == 'Q')
                count[0]--;
            else if (s.charAt(right) == 'W')
                count[1]--;
            else if (s.charAt(right) == 'E')
                count[2]--;
            else if (s.charAt(right) == 'R')
                count[3]--;

            while (left <= right &&
                    count[0] <= target &&
                    count[1] <= target &&
                    count[2] <= target &&
                    count[3] <= target) {

                ans = Math.min(ans, right - left + 1);

                if (s.charAt(left) == 'Q')
                    count[0]++;
                else if (s.charAt(left) == 'W')
                    count[1]++;
                else if (s.charAt(left) == 'E')
                    count[2]++;
                else if (s.charAt(left) == 'R')
                    count[3]++;

                left++;
            }
        }

        return ans;
    }
}
