#include <bits/stdc++.h>
#include <cstddef>

using namespace std;

vector<string> split_string(string);

bool compare(const vector<int> &v1, const vector<int> &v2){
    return v1[0] < v2[0];
}

bool compareStart(const vector<int> &v1, const vector<int> &v2){
    return v1[1] < v2[1];
}

long long subtract(vector<vector<int>> track){
    stack<vector<int>> stk;
    long long sum = 0;
    for(int i = 0;i<track.size();i++){
        if(stk.empty()){
            stk.push(track[i]);
        }else{
            vector<int> top = stk.top();
            if(top[2]>=track[i][1]-1){
                stk.pop();
                top[2] = max(track[i][2],top[2]);
                stk.push(top);
            }else{
                stk.push(track[i]);
            }
        }
    }
    while(!stk.empty()){
        vector<int> top = stk.top();
        sum += (top[2]-top[1]+1);
        stk.pop();
    }
    return sum;
}

 long long gridlandMetro(int n, int m, int k, vector<vector<int>> track) {
     long long res = 0;
    sort(track.begin(),track.end(),compare);
    vector<vector<int>> t;    
    for(int i = 0;i<k;){
        long long temp = track[i][0];
        do{
            t.insert(t.end(),track[i]);
            i++;
            if(i == k)break;
        }while(temp == track[i][0]);
        sort(t.begin(),t.end(),compareStart);
        res += subtract(t);
        t.clear();
        
    }
    return (unsigned long long)n*m - res;

}
int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nmk_temp;
    getline(cin, nmk_temp);

    vector<string> nmk = split_string(nmk_temp);

    int n = stoi(nmk[0]);

    int m = stoi(nmk[1]);

    int k = stoi(nmk[2]);

    vector<vector<int>> track(k);
    for (int i = 0; i < k; i++) {
        track[i].resize(3);

        for (int j = 0; j < 3; j++) {
            cin >> track[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

     long long result = gridlandMetro(n, m, k, track);

    fout << result << "\n";

    fout.close();

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}
