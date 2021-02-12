#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

long double sum(double k){//возвращает числовое значение элемента ряда для любого К
    k=1/(2*k+1);
    return k;
}


int main(){
    setlocale(0,""); // Включаем кириллицу

    double lim,res;
    cout << "Введите значение погрешности: ";
    cin >> lim;
    for(int k=1; sum(k)>=lim; ++k){ //суммируются элементы ряда
        res+=sum(k);
    }
    cout << res;

    return 0;
}
