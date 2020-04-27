#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

// Complete the decentNumber function below.
void decentNumber(int n) {
   int x=0, y = 0,a;
   bool consist = false;
   while(n>=y*5){
       a = n - y*5;
       if(a%3 == 0){
           x = a/3;  
           consist = true;
           break;
       }
       y++;
   }
   if(consist){
       if(x>0){
            string str1(x*3,'5');
            cout<<str1; 

       }
       if(y>0){
            string str2(y*5,'3');
            cout<<str2<<endl;
       }else{
           cout<<endl;
       }

       
   }else{
       cout<<-1<<endl;
   }
}

int main()
{
    string t_temp;
    getline(cin, t_temp);

    int t = stoi(ltrim(rtrim(t_temp)));

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string n_temp;
        getline(cin, n_temp);

        int n = stoi(ltrim(rtrim(n_temp)));

        decentNumber(n);
    }

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
