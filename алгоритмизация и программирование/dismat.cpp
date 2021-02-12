#include <iostream>
#include <clocale>
#include <My_library.h>
#include <cmath>

using namespace std;

int main(){
    int n=0;
    int a=pow(4,2);
    int b=pow(6,5);
    int c=pow(5,9);
    n=a*b;
/*
    for(int i=1; i<=a*b*c; i++)
        if((a*b*c)%i==0)
            n++;*/
    cout << n;
    return 0;
}
