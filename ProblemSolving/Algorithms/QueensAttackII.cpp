#include <bits/stdc++.h>
using namespace std;

vector<string> split_string(string);

// Complete the queensAttack function below.
//For code description click here https://link.medium.com/CuIsQKakU5
int queensAttack(int n, int k, int r_q, int c_q, vector<vector < int>> obstacles)
{
	int dist[8];

	dist[0] = c_q - 1;
	dist[1] = n - r_q;
	dist[2] = n - c_q;
	dist[3] = r_q - 1;

	dist[4] = min(dist[0], dist[1]);
	dist[5] = min(dist[1], dist[2]);
	dist[6] = min(dist[2], dist[3]);
	dist[7] = min(dist[3], dist[0]);

	int x, y;
	while (--k >= 0)
	{
		y = obstacles[k][0] - r_q;
		x = obstacles[k][1] - c_q;

		if (x == 0)
		{
			if (y > 0)
			{
				dist[1] = min(dist[1], y - 1);
			}
			else
			{
				dist[3] = min(dist[3], -(y + 1));
			}
		}
		else if (y == 0)
		{
			if (x > 0)
			{
				dist[2] = min(dist[2], x - 1);
			}
			else
			{
				dist[0] = min(dist[0], -(x + 1));
			}
		}
		else
		{
			float m = (float) y / x;
			if (m == 1.0)
			{
				if (x > 0)
				{
					dist[5] = min(dist[5], x - 1);
				}
				else
				{
					dist[7] = min(dist[7], -y - 1);
				}
			}
			else if (m == -1.0)
			{
				if (x > 0)
				{
					dist[6] = min(dist[6], x - 1);
				}
				else
				{
					dist[4] = min(dist[4], y - 1);
				}
			}
			else
			{
				continue;
			}
		}
	}

	int res = 0;
	for (int i = 0; i < 8; i++)
	{
		res += dist[i];
	}

	return res;
}

int main()
{
	ofstream fout(getenv("OUTPUT_PATH"));

	string nk_temp;
	getline(cin, nk_temp);

	vector<string> nk = split_string(nk_temp);

	int n = stoi(nk[0]);

	int k = stoi(nk[1]);

	string r_qC_q_temp;
	getline(cin, r_qC_q_temp);

	vector<string> r_qC_q = split_string(r_qC_q_temp);

	int r_q = stoi(r_qC_q[0]);

	int c_q = stoi(r_qC_q[1]);

	vector<vector < int>> obstacles(k);
	for (int i = 0; i < k; i++)
	{
		obstacles[i].resize(2);

		for (int j = 0; j < 2; j++)
		{
			cin >> obstacles[i][j];
		}

		cin.ignore(numeric_limits<streamsize>::max(), '\n');
	}

	int result = queensAttack(n, k, r_q, c_q, obstacles);

	fout << result << "\n";

	fout.close();

	return 0;
}

vector<string> split_string(string input_string)
{
	string::iterator new_end = unique(input_string.begin(), input_string.end(), [](const char &x, const char &y)
	{
		return x == y and x == ' ';
	});

	input_string.erase(new_end, input_string.end());

	while (input_string[input_string.length() - 1] == ' ')
	{
		input_string.pop_back();
	}

	vector<string> splits;
	char delimiter = ' ';

	size_t i = 0;
	size_t pos = input_string.find(delimiter);

	while (pos != string::npos)
	{
		splits.push_back(input_string.substr(i, pos - i));

		i = pos + 1;
		pos = input_string.find(delimiter, i);
	}

	splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

	return splits;
}