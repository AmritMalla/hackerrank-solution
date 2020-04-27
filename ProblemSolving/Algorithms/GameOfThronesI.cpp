#include <bits/stdc++.h>

using namespace std;

// Complete the gameOfThrones function below.
string gameOfThrones(string a) {
    
    int ans[26] = {0};
    for(int i = 0;i<a.length();i++){
        if(ans[a[i] - 'a'] == 0){
            ans[a[i] - 'a']++;
        }else{
            ans[a[i] - 'a']--;
        }
    }
    int sum = 0;
    for(int i = 0;i<26;i++){
        sum +=ans[i];
    }
    if(sum <=1){
        return "YES";
    }
    return "NO";


}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = gameOfThrones(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
