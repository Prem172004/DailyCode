class Solution {
public:
    double power(double x, int n) {
        if (n == 0)
            return 1;
        double half = power(x, n / 2);
        double result = half * half;
        return (n % 2 == 0) ? result : result * x;
    }
    double myPow(double x, int n) { double ans = power(x, n);
    if(n < 0) return 1.0/ans;
    return ans;
    }
};