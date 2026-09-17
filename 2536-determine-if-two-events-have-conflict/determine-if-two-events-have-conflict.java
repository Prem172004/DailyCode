class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int s1 = toMin(event1[0]);
        int e1 = toMin(event1[1]);

        int s2 = toMin(event2[0]);
        int e2 = toMin(event2[1]);

        return s1 <= e2 && s2 <= e1;
    }

    int toMin(String event) {
        int hr = Integer.parseInt(event.substring(0,2));
        int min = Integer.parseInt(event.substring(3,5));

        return hr*60 + min;
    }
}