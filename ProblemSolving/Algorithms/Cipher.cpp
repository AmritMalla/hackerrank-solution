#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);


// Complete the cipher function below.
string cipher(int k, string s) {
    int n = s.length()-k+1, i = s.length()-1,currentOne=0;
    string current ="";
    char *result = new char[n];
    char x;
    while(--n>=0){
        current += s[i];
        if(s[i]=='1')++currentOne;
        //take ith character 
        //add it to xor string
        //if xor string length is less than k just xor that to find string
        //if xor string length is greater than or equals to k then remove last or first element
        x = (currentOne%2==0)?'0':'1';
        if(current.length() == k){
            if(current[0]=='1')--currentOne;
            current.erase(current.begin());
            
        }
        if(current[current.length()-1] == '1' )--currentOne;
        current.erase(current.end()-1);
        current += x;
        if(x=='1')++currentOne;
        *(result+n) = x;
        --i;

    }
    return result;


}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nk_temp;
    getline(cin, nk_temp);

    vector<string> nk = split_string(nk_temp);

    int n = stoi(nk[0]);

    int k = stoi(nk[1]);

    string s;
    getline(cin, s);

    string result = cipher(k, s);

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
