#include <iostream>
#include <clocale>
#include <cstdlib>


using namespace std;



int main(){
    setlocale(LC_CTYPE, "rus");

    int n=10;
    int mass[n];
    int k=0;

    for(int i=0; i<n; ++i)
        mass[i]=rand()%10;
    cout << "Массив данных:\n";

    for(int i=0; i<n; ++i)
        cout << mass[i] << " ";

    cout << "\nКоличество элементов с нечётными значениями и чётными номерами: ";

    for(int i=0; i<n; ++i){
        if((mass[i]%2==1)&&(i%2==1))
            k++;
    }

    cout << k << endl;

    return 0;
}
