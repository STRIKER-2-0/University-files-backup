#include <iostream>

using namespace std;

int main()
{
    int i=2147483647;
    char ch=-127;
    long long L=9223372036854775807;
    cout << "INT MAX: " << i << endl;
    cout << "INT MAX+1: " << i+1 << endl;
    cout << "CHAR MIN: " << ch << endl;
    cout << "CHAR MIN-1: " << ch-1 << endl;
    cout << "LONG LONG MAX: " << L << endl;
    cout << "LONG LONG MAX+1: " <<L+1 << endl;

    return 0;
}

