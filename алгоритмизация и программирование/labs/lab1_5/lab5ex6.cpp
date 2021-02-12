#include <iostream>
#include <clocale>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "rus");
    int N;
    cout << "Введите N: ";
    cin >> N;
    for(int i=2; i<N; ++i){
        if(N%i==0){
            cout << "Число N - составное. Наименьший натуральный делитель, отличный от единицы: " << i;
            return 0;
        }

    }
    cout << "Число N - простое";
    return 0;
}
