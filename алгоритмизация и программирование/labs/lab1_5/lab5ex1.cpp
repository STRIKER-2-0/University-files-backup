#include <iostream>
#include <clocale>

using namespace std;

long double fact(int N)
{
    if(N<0) // если пользователь ввел отрицательное число
        return 0; // возвращаем ноль
    if(N==0) // если пользователь ввел ноль,
        return 1; // возвращаем факториал от нуля -  1
    else // Во всех остальных случаях
        return N*fact(N-1); // делаем рекурсию.
}

int main(){
    setlocale(0,""); // Включаем кириллицу
    double lim=0.0001; //задаём предел
    double e=0;
    for(int k=0; (1/fact(k))>=lim; ++k)
        e=e+1/fact(k);
    cout << "Число е=" << e;

    return 0;
}
