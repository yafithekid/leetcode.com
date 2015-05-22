#include <cstdio>
using namespace std;

class Solution {
public:
    int mySqrt(int x) {
        if (x == 0){
            return 0;
        } else {
            int l = 0;
            int r = 46340;
            while (l + 1 < r){
                int m = (r + l) / 2;
                if (m * m > x){
                    r = m - 1;
                } else {
                    l = m;
                }
            }
            if (x / r >= r){
                return r;
            } else {
                return l;
            }
        }
    }
};