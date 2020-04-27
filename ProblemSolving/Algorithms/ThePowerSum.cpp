#include <bits/stdc++.h>

using namespace std;

int findSet(vector<int> &list,int i,int sum, int target){  

    if(sum == target){
        return 1;
    }else if(sum > target || i>=list.size()){
        return 0;
    }else{
        return  findSet(list,i+1,sum+list[i],target) + findSet(list,i+1,sum,target);
    }
    
}

// Complete the powerSum function below.
int powerSum(int X, int N) {
    vector<int> list;
    int sum = 0;
    for(int i = floor(pow(X,1.0/N));i>=1;i--){
        int n = pow(i,N);
        sum+=n;
        list.insert(list.begin(),n);
    }
    return findSet(list,0,0,X);
    
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int X;
    cin >> X;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int N;
    cin >> N;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int result = powerSum(X, N);

    fout << result << "\n";

    fout.close();

    return 0;
}
