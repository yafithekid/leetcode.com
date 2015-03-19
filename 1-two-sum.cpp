#include <map>
#include <algorithm>

class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        unordered_map<int,int> hashmap;
        for(int i = 0; i < (int) numbers.size(); i++){
            hashmap[numbers[i]] = i + 1;
        }
        for(int i = 0; i < (int) numbers.size(); i++){
            if (hashmap.count(target - numbers[i]) == 1 && (i+1) != (hashmap[target - numbers[i]])){
                vector<int> ret;
                int x = hashmap[target - numbers[i]];
                ret.push_back(min(i+1,x));
                ret.push_back(max(i+1,x));
                return ret;
            }
            
            
        }
    }
};