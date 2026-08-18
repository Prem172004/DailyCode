class Solution {
    List<List<String>> result = new ArrayList<>();

    boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    void part(String s, int st, List<String> path) {
        if (st == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = st + 1; i <= s.length(); i++) {
            String piece = s.substring(st, i);
            if (isPalindrome(piece)) {
                path.add(piece);
                part(s, i, path);
                path.remove(path.size() - 1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        part(s, 0, new ArrayList<>());
        return result;
    }
}