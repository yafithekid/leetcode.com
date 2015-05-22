#include <vector>
#include <map>
#include <queue>
#define ii pair<int,int> 
using namespace std;

class Solution {
public:
    set<int> daftar;
    set<int>::iterator le,ri;

    int largestRectangleArea(vector<int>& height) {
        int nrect = (int) height.size();
        priority_queue<ii,vector<ii>,greater<ii> > pq;
        int hmin;
        for(int i = 0; i < (int) height.size(); i++){
            if (i == 0) hmin = height[i];
            else hmin = min(hmin,height[i]);
            pq.push(ii(height[i],i));
        }

        int last = hmin;
        int result = hmin * nrect;
        vector<int> buffer_list;

        while(!pq.empty()){
            ii top = pq.top();
            pq.pop();
            int h = top.first;
            int pos = top.second;

            //khusus yang tingginya paling kecil, dibuang
            if (h == hmin){
                daftar.insert(pos);
                continue;
            //masukin semua yang ada dibuffer
            }
            if (last != h){
                for(int i = 0; i < (int) buffer_list.size(); i++){
                    daftar.insert(buffer_list[i]);
                }
                buffer_list.clear();
                last = h;
            }

            //pos tidak ada di set ya
            //cari posisi disebelah kirinya
            le = daftar.lower_bound(pos);
            int lpos,rpos;
            int tmp;
            if (le == daftar.end()){
                ri = le;
                ri--;
                int lpos = (*ri);
                int rpos = nrect - 1;
                tmp = h * (rpos - lpos);
            }
            else if (le == daftar.begin()){
                int lpos = 0;
                int rpos = (*le);
                tmp = h * (rpos - lpos);
            } else {
                ri = le;
                ri--;
                int lpos = *(ri);
                int rpos = *le;
                tmp = h * (rpos - lpos - 1);
            }
            result = max(result,tmp);
            buffer_list.push_back(pos);
        }
        return result;
    }
};