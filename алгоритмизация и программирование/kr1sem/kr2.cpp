#include <iostream>
#include <clocale>
#include <cstdlib>

using namespace std;


int main(){
    setlocale(LC_CTYPE, "rus");
    int n=5;
    int mass[n][n];
    double s=0.0;
    int res=0;

    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            mass[i][j]=rand()%10;
            s+=mass[i][j];
        }
    }

    s=s/(n*n);
    cout << "Массив данных:\n";

    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cout << mass[i][j] << " ";
            if(mass[i][j]<s)
                res++;
        }
        cout << endl;
    }

    cout << "Среднее арифметическое: " << s << "\n";
    cout << "Количество элементов, значения которых меньше среднего арифметического всех элементов: " << res;


    return 0;
}
