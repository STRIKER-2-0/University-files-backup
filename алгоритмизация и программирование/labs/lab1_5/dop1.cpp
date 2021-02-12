#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "rus");
    int k,M,res=0;
    cin >> k >> M;
    while(pow(k,res)<=M)
        ++res;
    cout << res-1;

    return 0;
}
