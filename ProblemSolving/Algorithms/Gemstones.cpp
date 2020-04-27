#include <bits/stdc++.h>

using namespace std;

unordered_set<char> getSet(string s){
    unordered_set<char> set;
    for(int i = 0;i<s.length();i++){
        if(set.find(s[i]) ==  set.end()){
            set.insert(s[i]);
        }
    }
    return set;
}

// Complete the gemstones function below.
int gemstones(vector<string> arr) {
    string min = arr[0];
    unordered_set<char> until = getSet(arr[0]);
    for(int i = 1;i<arr.size();i++){
        unordered_set<char> now = getSet(arr[i]);
        unordered_set<char> next;

        unordered_set<char> :: iterator itr; 
        for (itr = until.begin(); itr != until.end(); itr++) {
            if(now.find(*itr)!=now.end()){
                next.insert(*itr);
            }
        }
        until = next;
    }
    return until.size();
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<string> arr(n);

    for (int i = 0; i < n; i++) {
        string arr_item;
        getline(cin, arr_item);

        arr[i] = arr_item;
    }

    int result = gemstones(arr);

    fout << result << "\n";

    fout.close();

    return 0;
}
