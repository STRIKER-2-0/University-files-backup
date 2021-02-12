#include <iostream>
#include <clocale>
#include <cmath>

using namespace std;

long double fact(int N){
    if(N<0) // если пользователь ввел отрицательное число
        return 0; // возвращаем ноль
    if(N==0) // если пользователь ввел ноль,
        return 1; // возвращаем факториал от нуля - 1
    else // Во всех остальных случаях
        return N*fact(N-1); // делаем рекурсию.
}

long double sum(double x, double lim){ //функция sum возвращает значение экспоненты в заданной точке
    double e=0;
    for(int k=0; (pow(x,k)/fact(k))>=lim; ++k)
        e=e+pow(x,k)/fact(k);
    return e;

}

long double delta(float x,double lim){//фукция delta возвращает значение разности моей и встроенной функций экспоненты
    return exp(x)-sum(x,lim);
}

int main(){
    setlocale(0,""); // Включаем кириллицу

    double lim;
    cout << "Введите значение погрешности: ";
    cin >> lim;
    cout <<  "x\tsum\texp\tdelta\n-------------------------------\n";  //верхушка таблицы
    for (float x=0; x<2.1; x+=0.1){                          //в цикле просто поочередно вызываем тр функции для значей таблицы
        cout << x <<"\t"<< sum(x,lim) <<"\t"<< exp(x) <<"\t"<< delta(x,lim) << endl;
    }
    return 0;
}
