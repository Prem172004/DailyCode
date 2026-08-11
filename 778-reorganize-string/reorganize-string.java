class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Map<Character, Integer> hmap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
            if (hmap.get(c) > (n + 1) / 2)
                return "";
        }
        StringBuilder sol = new StringBuilder();
        for (Map.Entry<Character, Integer> m : hmap.entrySet()) {
            pq.offer(new int[] { m.getKey(), m.getValue() });
        }

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (pq.isEmpty()) {
                if (first[1] > 1) {
                    return "";
                }
            sol.append((char) first[0]);
            break;
            }
            int[] second = pq.poll();

            sol.append((char) first[0]);
            sol.append((char) second[0]);

            first[1]--;
            second[1]--;

            if (first[1] > 0)
                pq.offer(first);
            if (second[1] > 0)
                pq.offer(second);

        }
        return sol.toString();
    }
}