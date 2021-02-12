#include <iostream>
#include <clocale>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "rus");
    int mass[20];
    int res[10];
    short n=1;
    cout << "Введите 20 результатов: ";
    for(int i=0; i<20; ++i)
        cin >> mass[i];
    for(int i=0; i<10; ++i)
        res[i]=0;
    for(int i=0; i<20; ++i){
        n=mass[i];
        res[n-1]+=1;
    }
    cout << "Количество оценок: " << endl;
    for(int i=0; i<10; ++i)
        cout << i+1 <<"  -\t"<< res[i] << endl;
        return 0;

}
