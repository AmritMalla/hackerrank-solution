#include <bits/stdc++.h>
using namespace std;

// Complete the cavityMap function below.
vector<string> cavityMap(vector<string> grid)
{
	int n = grid.size();
	for (int i = 1; i < n - 1; i++)
	{
		for (int j = 1; j < n - 1; j++)
		{
			int m = grid[i][j];
			int adjacent[] = { grid[i - 1][j], grid[i][j + 1], grid[i + 1][j], grid[i][j - 1]
			};
			if (m > adjacent[0] && m > adjacent[1] && m > adjacent[2] && m > adjacent[3])
			{
				grid[i][j] = 'X';
			}
		}
	}

	return grid;
}

int main()
{
	ofstream fout(getenv("OUTPUT_PATH"));

	int n;
	cin >> n;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	vector<string> grid(n);

	for (int i = 0; i < n; i++)
	{
		string grid_item;
		getline(cin, grid_item);

		grid[i] = grid_item;
	}

	vector<string> result = cavityMap(grid);

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