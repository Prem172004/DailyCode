class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        wordSet.remove(beginWord);
        int steps = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            steps++;
            for(int i = 0; i < size; i++) {
                char[] word = q.poll().toCharArray();
                for(int j = 0; j < word.length; j++) {
                    char orig = word[j];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        word[j] = ch;
                        String next = new String(word);
                        if(next.equals(endWord)) return steps;
                        if(wordSet.contains(next)) {
                            q.offer(next);
                            wordSet.remove(next);
                        }
                        
                    }
                    word[j] = orig;
                }
            }
        }
        return 0;
    }
}