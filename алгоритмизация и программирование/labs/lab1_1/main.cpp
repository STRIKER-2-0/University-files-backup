#include <iostream>

using namespace std;

int main()
{
    int n,k;
    cout << "Enter a number of seconds: " << endl;
    cin >> n;
    k=n%3600;
    cout << "The number of seconds after beginning a new hour is: " << k << endl;
    return 0;
}
