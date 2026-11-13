// copy kia hain maine 
class Solution {
    public int compress(char[] chars) {

        if (chars.length == 1) return 1;

        StringBuilder solution = new StringBuilder();

        Map<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {

            hmap.put(chars[i], hmap.getOrDefault(chars[i], 0) + 1);
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {

                solution.append(chars[i]);

                int count = hmap.get(chars[i]);

                if (count > 1) {
                    solution.append(count);
                }

                hmap.clear();
            }
        }

        for (int i = 0; i < solution.length(); i++) {
            chars[i] = solution.charAt(i);
        }

        return solution.length();
    }
}