#include <iostream>
#include <clocale>
#include <cmath>
#include <My_library.h>

using namespace std;

bool simple(int n){
    for(int i=2; i<=sqrt(n); i++)
        if (n%i==0)
            return false;
    return true;
}

int main(){
    setlocale(LC_CTYPE, "rus");
    int n;

    cout << "Введите n: "; n=(int)cin_valid();
    int arr[n+1];
    for(int i=0; i<n+1; i++)
        arr[i]=i;


    for(int i=2; i*i<=n+1; i++)
        if(simple(i))
            for(int j=i*i; j<=n+1; j+=i)
                arr[j]=0;


    cout << "Все простые числа до n: " << endl;
    for(int i=0; i<n+1; i++)
        if((arr[i]!=0)&&(arr[i]!=1))
            cout << arr[i] << " ";

    return 0;
}
