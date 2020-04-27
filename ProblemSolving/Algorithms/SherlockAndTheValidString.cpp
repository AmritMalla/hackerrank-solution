#include <bits/stdc++.h>

using namespace std;

// Complete the isValid function below.
string isValid(string s) {
    int str[26] = {0},singleCount = 0;
    bool present[26] = {false},singleOne = true;
    for(int i = 0;i<s.length();i++){
        int x = str[s[i] - 'a']++;
        present[s[i] - 'a'] = true;
    }
    vector<int> keys;
    for(int i =0;i<26;i++){
        if(present[i]){
            keys.push_back(str[i]);
        }
    }
    sort(keys.begin(),keys.end());

    if(keys.size() == 1 ||
    (keys[0] == 1 && keys[keys.size()-1] == keys[1]) ||
    (keys[0] != 1 && keys[keys.size()-1] - keys[0] <=1) ){
        return "YES";
    }
    
    return "NO";

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = isValid(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
