#include <bits/stdc++.h>

using namespace std;

// Complete the anagram function below.
int anagram(string s) {
    if(s.length()%2 != 0)
        return -1;
    
    string a  = s.substr(0,s.length()/2)
    , b = s.substr(s.length()/2,s.length()/2);

    int ans[26] = {0};
    for(int i = 0;i<a.length();i++){
        ans[a[i] - 'a']++;
    }
    for(int i = 0;i<b.length();++i){
        ans[b[i] - 'a']--;
    }
    long long int res = 0;
    for(int i = 0;i<26;i++){
        res += ans[i]>0?ans[i]:-ans[i];
    }
    return res/2;


}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        getline(cin, s);

        int result = anagram(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
