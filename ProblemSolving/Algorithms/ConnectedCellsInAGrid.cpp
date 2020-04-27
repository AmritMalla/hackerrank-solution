#include <bits/stdc++.h>

using namespace std;

int largestPool(vector<vector<int>> &matrix,int i,int j){
    int count = 0;
    if(matrix[i][j] == 0){
        return count;
    }else{
        count++;
        matrix[i][j] = 0;
        if(matrix[i-1][j-1] == 1){
            count += largestPool(matrix,i-1,j-1);
        }
        if(matrix[i-1][j] == 1){
            count += largestPool(matrix,i-1,j);
        }
        if(matrix[i-1][j+1] == 1){
            count += largestPool(matrix,i-1,j+1);
        }
        if(matrix[i][j-1] == 1){
            count += largestPool(matrix,i,j-1);
        }
        if(matrix[i][j+1] == 1){
            count += largestPool(matrix,i,j+1);
        }
        if(matrix[i+1][j-1] == 1){
            count += largestPool(matrix,i+1,j-1);
        }
        if(matrix[i+1][j] == 1){
            count += largestPool(matrix,i+1,j);
        }
        if(matrix[i+1][j+1] == 1){
            count += largestPool(matrix,i+1,j+1);
        }
    }
    return count;

}
int connectedCell(vector<vector<int>> matrix) {
    int res = 0,size;
    vector<int> bound(matrix[0].size(), 0);
    matrix.insert(matrix.begin(),bound);
    matrix.insert(matrix.end(),bound);
    for(int i =0;i<matrix.size();i++){
        matrix[i].insert(matrix[i].begin(),0);
        matrix[i].insert(matrix[i].end(),0);
    }

    for(int i = 1;i<matrix.size()-1;i++){
        for(int j = 1;j<matrix[i].size()-1;j++){
            if(matrix[i][j] == 1){
                size = largestPool(matrix,i,j);
                if(size>res){
                    res = size;
                }
            }
        }
    }
    return res;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int m;
    cin >> m;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<vector<int>> matrix(n);
    for (int i = 0; i < n; i++) {
        matrix[i].resize(m);

        for (int j = 0; j < m; j++) {
            cin >> matrix[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int result = connectedCell(matrix);

    fout << result << "\n";

    fout.close();

    return 0;
}
