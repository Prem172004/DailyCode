class Solution {
    public char[] solve(char[]s, int i, int j) {
        if(i >= j) return s;
        char temp = s[j];
        s[j] = s[i];
        s[i] = temp;
        return solve(s,i+1,j-1);

    }
    public void reverseString(char[] s) {
        s = solve(s,0,s.length - 1);
    }
}