#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

int Mpow(int k,int m){//возвращает максимальную степень числа k, в которой оно не превышает m
    int res=0;
    while(pow(k,res)<=m)
        ++res;
    return res-1;

}

int main(){
    setlocale(0,""); // Включаем кириллицу
    int N,k,n,d;
    cout << "Введите число: ";
    cin >> N;
    cout << "Введите основание системы счисления для перевода(от 2 до 16): ";
    cin >> k;
    if((k<2)||(k>16)){
        cout << "Некорректное значение основания системы исчисления!!!!";
        return 0;
    }

    n=Mpow(k,N);
    cout << "Число в новой системе исчисления: ";
    while(n>=0){
        d=N/pow(k,n);
        if(d>=10){
            switch(d){
                case 10: cout << "a"; break;
                case 11: cout << "b"; break;
                case 12: cout << "c"; break;
                case 13: cout << "d"; break;
                case 14: cout << "e"; break;
                case 15: cout << "f"; break;
            }
        }
        else
            cout << d;
        N=N-d*pow(k,n);
        n=n-1;
    }
    return 0;
}
