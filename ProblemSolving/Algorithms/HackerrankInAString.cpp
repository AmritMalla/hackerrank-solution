#include <bits/stdc++.h>
using namespace std;

int find(char c, string s, int n)
{
	for (int i = n; i < s.size(); i++)
	{
		if (c == s[i])
		{
			return i;
		}
	}

	return -1;
}

// Complete the hackerrankInString function below.
string hackerrankInString(string s)
{
	int i = 0;
	string hr = "hackerrank";
	for (int j = 0; j < hr.size(); j++)
	{
		cout << hr[j];
		int p = find(hr[j], s, i);
		if (j == 9)
		{
			return "YES";
		}

		if (p == -1)
		{
			return "NO";
		}
		else
		{
			i = p + 1;
		}
	}

	return "YES";

}

int main()
{
	ofstream fout(getenv("OUTPUT_PATH"));

	int q;
	cin >> q;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	for (int q_itr = 0; q_itr < q; q_itr++)
	{
		string s;
		getline(cin, s);

		string result = hackerrankInString(s);

		fout << result << "\n";
	}

	fout.close();

	return 0;
}