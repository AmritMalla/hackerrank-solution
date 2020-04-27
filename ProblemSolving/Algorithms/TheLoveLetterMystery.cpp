#include <bits/stdc++.h>

using namespace std;

// Complete the theLoveLetterMystery function below.
int theLoveLetterMystery(string s) {
     int res = 0;
        int i, j;
        int n = s.length()/2;
        if(s.length()%2 == 0){
            i = n-1;
            j = n;
        }else{
            i = n-1;
            j = n+1;
        }
        while(i>=0){
            int d = s[i] - s[j];
            d = (d>=0)?d:-d;
            --i;++j;
            res +=d;
        }
        return res;

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

        int result = theLoveLetterMystery(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
