#include <iostream>

using namespace std;

int main()
{
    int N,M,P;
    cout << "Enter a number of voteds: ";
    cin >> N;
    cout << "Enter a number of votes for 'YES': ";
    cin >> M;
    P=((double)M/N)*100;
    cout << "The persent of votes for 'YES': " << P << "%" << endl;


    return 0;
}

