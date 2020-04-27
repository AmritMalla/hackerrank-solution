#include <bits/stdc++.h>

using namespace std;

// Complete the jimOrders function below.
bool sortcol( const vector<int>& v1, 
               const vector<int>& v2 ) { 
    int a = v1[1]+v1[2], b = v2[1]+v2[2];
    if(a == b){
        return v1[0]<v2[0];
    }
 return a < b; 
}
vector<int> jimOrders(vector<vector<int>> orders) {
    vector<int> res;
    for(int i = 0;i<orders.size();i++){
        orders[i].insert(orders[i].begin(), i+1);
    }
    sort(orders.begin(), orders.end(),sortcol); 
    for(int i = 0;i<orders.size();i++){
        res.insert(res.end(), orders[i][0]);
    }

    return res;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<vector<int>> orders(n);
    for (int i = 0; i < n; i++) {
        orders[i].resize(2);

        for (int j = 0; j < 2; j++) {
            cin >> orders[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    vector<int> result = jimOrders(orders);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << " ";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}
