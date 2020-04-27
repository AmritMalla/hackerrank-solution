#include <bits/stdc++.h>
using namespace std;

// Complete the happyLadybugs function below.
string happyLadybugs(string b)
{
	unordered_map<char, int> umap;
	bool contains = false;
	for (int i = 0; i < b.length(); i++)
	{
		if (b[i] == '_')
		{
			contains = true;
			continue;
		}

		if (umap.find(b[i]) == umap.end())
		{
			umap.insert(make_pair(b[i], 1));
		}
		else
		{
			int newVal = umap.at(b[i]) + 1;
			umap[b[i]] = newVal;
		}
	}

	unordered_map<char, int>::iterator itr;
	for (itr = umap.begin(); itr != umap.end(); itr++)
	{
		if (itr->second < 2)
		{
			return "NO";
		}
	}

	if (!contains)
	{
		int minCount = 1;
		char temp = b[0];
		for (int i = 1; i <= b.length(); i++)
		{
			if (temp == b[i])
			{
				minCount++;
			}
			else
			{
				if (minCount < 2)
				{
					return "NO";
				}

				minCount = 1;
				temp = b[i];
			}
		}
	}

	return "YES";
}

int main()
{
	ofstream fout(getenv("OUTPUT_PATH"));

	int g;
	cin >> g;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	for (int g_itr = 0; g_itr < g; g_itr++)
	{
		int n;
		cin >> n;
		cin.ignore(numeric_limits<streamsize>::max(), '\n');

		string b;
		getline(cin, b);

		string result = happyLadybugs(b);

		fout << result << "\n";
	}

	fout.close();

	return 0;
}