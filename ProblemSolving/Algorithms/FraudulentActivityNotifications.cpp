#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);
double findMedian(vector<int> v){
    int s = v.size();
    if(s%2 !=0){
        return v[(s-1)/2];
    }else{
        return (v[s/2] + (float)v[s/2 - 1])/2;
    }

}

// Complete the activityNotifications function below.
int activityNotifications(vector<int> expenditure, int d) {
    int res = 0;
    bool even = (d%2==0)?true:false;
    vector<int> median;
    int i = d;
    while(--i>=0){
        median.insert(median.begin(),expenditure[i]);
    }
    sort(median.begin(),median.end());
    i = d;
    float med  =0;
    do{
        if(!even){
            med = median[(d-1)/2];
        }else{
            med = (median[d/2] + (float)median[d/2 - 1])/2;
        }

        if((float)expenditure[i]>=med*2){
            res++;
        }
        
        // add ith element
        vector<int>::iterator position = find(median.begin(), median.end(), expenditure[i-d]);
        median.erase(position);
        position = lower_bound( median.begin(), median.end(), expenditure[i], std:: less<int>());
        median.insert(position, expenditure[i]);
        i++;
    }while(i<expenditure.size());
    return res;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nd_temp;
    getline(cin, nd_temp);

    vector<string> nd = split_string(nd_temp);

    int n = stoi(nd[0]);

    int d = stoi(nd[1]);

    string expenditure_temp_temp;
    getline(cin, expenditure_temp_temp);

    vector<string> expenditure_temp = split_string(expenditure_temp_temp);

    vector<int> expenditure(n);

    for (int i = 0; i < n; i++) {
        int expenditure_item = stoi(expenditure_temp[i]);

        expenditure[i] = expenditure_item;
    }

    int result = activityNotifications(expenditure, d);

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
