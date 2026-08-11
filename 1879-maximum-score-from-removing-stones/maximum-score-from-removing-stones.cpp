class Solution {
public:
    int maximumScore(int a, int b, int c) {
        int sum = a+b+c;
        int mc = max(a , max(b,c));
        if(mc > sum - mc){
            return sum - mc;
        }
        return sum / 2;
        
        
    }
};