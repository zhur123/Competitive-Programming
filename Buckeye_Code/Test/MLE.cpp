#include <bits/stdc++.h>
using namespace std;

const int N = 1e8;

int a[N];

// Driver Code
int main()
{
	for (int i = 0; i < N; ++i) {
		a[i] = i;
	}
	cout << a[N - 1];
	return 0;
}
