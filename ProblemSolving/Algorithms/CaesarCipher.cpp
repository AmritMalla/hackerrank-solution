#include <bits/stdc++.h>
using namespace std;

// Complete the caesarCipher function below.
string caesarCipher(string s, int k)
{
	string ss;
	k = k % 26;

	for (int i = 0; i < s.size(); ++i)
	{
		char c = s[i];
		int x = c;
		if (x >= 65 && x <= 90)
		{
			x = x + k;
			if (x > 90) x -= 26;
		}
		else if (x >= 97 && x <= 122)
		{
			x = x + k;
			if (x > 122) x = x - 26;
		}

		char p = (char) x;
		ss += p;
	}

	return ss;

}

int main()
{
	ofstream fout(getenv("OUTPUT_PATH"));

	int n;
	cin >> n;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	string s;
	getline(cin, s);

	int k;
	cin >> k;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	string result = caesarCipher(s, k);

	fout << result << "\n";

	fout.close();

	return 0;
}