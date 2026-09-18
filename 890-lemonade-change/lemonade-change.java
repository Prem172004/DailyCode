class Solution {
    public boolean lemonadeChange(int[] bills) {
        int total5 = 0;
        int total10 = 0;

        for (int i : bills) {
            if (i == 5) {
                total5++;
            } else if (i == 10) {
                if (total5 == 0)
                    return false;
                total5--;
                total10++;
            } else if (i == 20) {
                if (total10 > 0 && total5 > 0) {
                    total10--;
                    total5--;
                } else if (total5 >= 3) {
                    total5 -= 3;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
