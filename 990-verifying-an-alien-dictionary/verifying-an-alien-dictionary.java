class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] hashSet = new int[26];

        int i = 0;

        // Store rank of each character
        for (char ch : order.toCharArray()) {
            hashSet[ch - 'a'] = i++;
        }

        // Compare adjacent words
        for (i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            int j = 0;

            while (j < s1.length() && j < s2.length()) {

                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {

                    if (hashSet[c1 - 'a'] > hashSet[c2 - 'a']) {
                        return false;
                    }

                    break;
                }

                j++;
            }
            if (j == s2.length() && s1.length() > s2.length()) {
                return false;
            }
        }

        return true;
    }
}
