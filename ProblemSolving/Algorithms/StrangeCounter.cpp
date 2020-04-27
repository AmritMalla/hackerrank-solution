#include <bits/stdc++.h>
using namespace std;

// Complete the strangeCounter function below.
long strangeCounter(long t)
{
	double x = (double) t / 3 + 1;
	double n = ceil(log2(x));
	return 3 *(pow(2, n) - 1) - t + 1;

}

int main()
{
	ofstream fout(getenv("OUTPUT_PATH"));

	long t;
	cin >> t;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	long result = strangeCounter(t);

	fout << result << "\n";

	fout.close();

	return 0;
}