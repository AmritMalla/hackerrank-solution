#include <bits/stdc++.h>

using namespace std;

// Complete the makingAnagrams function below.
int makingAnagrams(string a, string b) {
    
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
    return res;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s1;
    getline(cin, s1);

    string s2;
    getline(cin, s2);

    int result = makingAnagrams(s1, s2);

    fout << result << "\n";

    fout.close();

    return 0;
}
