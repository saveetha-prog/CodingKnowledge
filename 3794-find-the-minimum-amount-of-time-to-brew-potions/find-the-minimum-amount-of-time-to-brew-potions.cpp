class Solution {
public:
    long long minTime(vector<int>& skill, vector<int>& mana) {
        int n=skill.size(),m=mana.size();
        vector<long> done(n,0);
        for(int position=0;position<m;position++){
            for(int wizard=0;wizard<n;wizard++){
                if(wizard==0)
                done[wizard]=done[wizard]+1LL*mana[position]*skill[wizard];
                else
                done[wizard]=max(done[wizard],done[wizard-1])+1LL*mana[position]*skill[wizard];
            }
            for(int wizard=n-2;wizard>=0;wizard--){
                done[wizard]=done[wizard+1]-1LL*mana[position]*skill[wizard+1];
            }
        }
        return done[n-1];
    }
};