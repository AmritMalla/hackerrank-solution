#include <bits/stdc++.h>

using namespace std;

// Complete the stringConstruction function below.
int stringConstruction(string s) {
    bool ans[26] = {false};
    int count = 0;
    for(int i = 0;i<s.length();i++){
        if(!ans[s[i] - 'a']){
            ans[s[i] - 'a']= true;
            count++;
        }
    }
   return count;
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

        int result = stringConstruction(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
