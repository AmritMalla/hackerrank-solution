#include <bits/stdc++.h>

using namespace std;

// Complete the twoStrings function below.
string twoStrings(string a, string b) {
    
    int a1[26] = {0},b1[26] = {0};
    for(int i = 0;i<a.length();i++){
        a1[a[i] - 'a']++;
    }
    for(int i = 0;i<b.length();++i){
        b1[b[i] - 'a']++;
    }
    
    for(int i = 0;i<26;i++){
        if(a1[i]>0 && b1[i]>0){
            return "YES";
        }
    }
    return "NO";

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s1;
        getline(cin, s1);

        string s2;
        getline(cin, s2);

        string result = twoStrings(s1, s2);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
