#include <bits/stdc++.h>
using namespace std;

// Complete the organizingContainers function below.
string organizingContainers(vector<vector < int>> container)
{
	vector<long> boxes(container.size());
	vector<long> balls(container.size());

	long long rowSum = 0;
	for (int i = 0; i < container.size(); i++)
	{
		rowSum = 0;
		for (int j = 0; j < container[i].size(); j++)
		{
			boxes[j] += container[i][j];
			rowSum += container[i][j];
		}

		balls[i] = rowSum;

	}

	sort(boxes.begin(), boxes.end());
	sort(balls.begin(), balls.end());
	for (int i = 0; i < container.size(); i++)
	{
		if (boxes[i] != balls[i])
		{
			return "Impossible";
		}
	}

	return "Possible";

}

int main()
{
	ofstream fout(getenv("OUTPUT_PATH"));

	int q;
	cin >> q;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	for (int q_itr = 0; q_itr < q; q_itr++)
	{
		int n;
		cin >> n;
		cin.ignore(numeric_limits<streamsize>::max(), '\n');

		vector<vector < int>> container(n);
		for (int i = 0; i < n; i++)
		{
			container[i].resize(n);

			for (int j = 0; j < n; j++)
			{
				cin >> container[i][j];
			}

			cin.ignore(numeric_limits<streamsize>::max(), '\n');
		}

		string result = organizingContainers(container);

		fout << result << "\n";
	}

	fout.close();

	return 0;
}