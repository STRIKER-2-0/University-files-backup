#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

long double fact(int N)
{
    if(N<0) // если пользователь ввел отрицательное число
        return 0; // возвращаем ноль
    if(N==0) // если пользователь ввел ноль,
        return 1; // возвращаем факториал от нуля - 1
    else // Во всех остальных случаях
        return N*fact(N-1); // делаем рекурсию.
}

int main(){
    setlocale(0,""); // Включаем кириллицу
    double lim=0.0001,e=0,x;
    cout << "Введите значение х: ";
    cin >> x;

    for(int k=0; (1/fact(k))>=lim; ++k) //цикл немного изменился, но в остальном, та же программа
        e=e+pow(x,k)/fact(k);

    cout <<  "е^x=" << e;
    return 0;
}
