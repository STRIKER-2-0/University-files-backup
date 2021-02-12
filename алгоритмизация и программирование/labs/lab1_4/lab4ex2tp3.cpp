#include <iostream>

using namespace std;

int main()
{
    int n=0;
    int val=1;
    do{
        cout << n << " " << val << endl;
        ++n;
        val=val*2;
    }while(n<=6);


    return 0;
}

