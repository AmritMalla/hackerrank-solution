#include <bits/stdc++.h>
using namespace std;

// Complete the funnyString function below.
string funnyString(string s)
{
	int *diff = new int[s.length() - 1];
	int length = s.length() - 1;
	for (int i = 0; i < length; i++)
	{
		int d = s[i + 1] - s[i];
		diff[i] = (d >= 0) ? d : -d;
	}

	for (int i = length - 1; i >= 0; i--)
	{
		int d = s[i + 1] - s[i];
		int abs = (d >= 0) ? d : -d;

		if (diff[length - 1 - i] != abs)
		{
			return "Not Funny";
		}
	}

	return "Funny";

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

		string result = funnyString(s);

		fout << result << "\n";
	}

	fout.close();

	return 0;
}