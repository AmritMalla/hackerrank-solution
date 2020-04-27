#include <bits/stdc++.h>

using namespace std;
bool checkPalindrome(string s, int r){
    s.erase(r,1);
    int n = s.length()/2;
    int i = n-1, j;
    j = (s.length()%2 == 0)?n:n+1;
    while(i>=0){
        if(s[i] != s[j])
            return false;
        --i;++j;
    }
    return true;
}

int palindromeWithC(string s,int i, int j){
    while(i>=0){
        if(s[i] != s[j])
            return i;
        --i;++j;
    }
    return -1;

}


// Complete the palindromeIndex function below.
int palindromeIndex(string s) {
    for(int i = 0, j = s.length() - 1; i < j; i++, j--)  {
            if (s[i] != s[j]) {
                if (checkPalindrome(s,i)) {
                    return i;
                }
                if (checkPalindrome(s,j)) {
                    return j;
                }
            }
    }
 
    return -1;
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

        int result = palindromeIndex(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
