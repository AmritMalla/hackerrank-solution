#include <bits/stdc++.h>
using namespace std;

// Complete the weightedUniformStrings function below.
vector<string> weightedUniformStrings(string s, vector<int> queries)
{
	unordered_set<int> sett;
	char temp = '0';
	int v;
	for (int i = 0; i < s.length(); i++)
	{
		int t = s[i] - 96;
		if (temp == s[i])
		{
			v += t;
		}
		else
		{
			v = t;
			temp = s[i];
		}

		sett.insert(v);
	}

	vector<string> res(queries.size(), "Yes");
	for (int i = 0; i < queries.size(); i++)
	{
		if (sett.find(queries[i]) == sett.end())
		{
			res[i] = "No";
		}
	}

	return res;

}

int main()
{
	ofstream fout(getenv("OUTPUT_PATH"));

	string s;
	getline(cin, s);

	int queries_count;
	cin >> queries_count;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	vector<int> queries(queries_count);

	for (int i = 0; i < queries_count; i++)
	{
		int queries_item;
		cin >> queries_item;
		cin.ignore(numeric_limits<streamsize>::max(), '\n');

		queries[i] = queries_item;
	}

	vector<string> result = weightedUniformStrings(s, queries);

	for (int i = 0; i < result.size(); i++)
	{
		fout << result[i];

		if (i != result.size() - 1)
		{
			fout << "\n";
		}
	}

	fout << "\n";

	fout.close();

	return 0;
}