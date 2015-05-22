#include <vector>
#include <map>

using namespace std;


class Solution {
public:
    unordered_map<int,int> counter;

    int firstMissingPositive(vector<int>& nums) {
        for(int i = 0; i < (int) nums.size(); i++){
            counter[nums[i]] = 1;
        }
        int limit = nums.size() + 30;
        for(int i = 1; i < limit; i++){
            if (counter.count(i) == 0){
                return i;
            }
        }
    }
};