class Solution {
    List<String> result = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        backtrack(0,turnedOn,0,0);
        return result;
    }

    void backtrack(int s, int r, int h, int m) {
        if(r == 0) {
            if(h < 12 && m < 60) {
                result.add(String.format("%d:%02d",h,m));
            }
            return;
        }
        for(int i = s; i < 10; i++) {
            if(i < 4) {
                backtrack(i+1,r-1,h + (1 << i), m);
            } else {
                backtrack(i+1,r-1,h,m + (1 << (i - 4)));
            }
        }
    }
}