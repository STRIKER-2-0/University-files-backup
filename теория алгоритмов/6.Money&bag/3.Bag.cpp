//задача о рюкзаке
#include <iostream>
#include <My_library.h>

using namespace std;

int main(){
    setlocale(LC_CTYPE, "rus");

    cout << "Введите кол-во вещей: ";   //ввод корректного кол-ва вещей
    int N=(int)cin_valid();
    while_neg(N);

    int things[2][N];
    cout << "Введите вес вещей: ";
    for(int i=0; i<N; i++){
        things[0][i]=(int)cin_valid();
        while_neg(things[0][i]);
    }
    //quick(things[0], 0, N-1);

    cout << "Введите цену соответствующих вещей: ";     //ввод корректных номиналов
    for(int i=0; i<N; i++){
        cout << things[0][i] << ": ";
        things[1][i]=(int)cin_valid();
        while_neg(things[0][i]);
        //cout << endl;
    }
    for(int i=0; i<N; i++)
        for(int j=0; j<N-1; j++)
            if(things[1][j]>things[1][j+1]){
                swap(things[0][j],things[0][j+1]);
                swap(things[1][j],things[1][j+1]);
            }

    cout << "Введите объем рюкзака: ";
    int capacity=(int)cin_valid();
    while_neg(capacity);


    int counter=0;
    for(int i=N-1; (i>=0)&&(capacity-things[0][i]>0); i--){    //подсчет жадным алгоритмом
        //while(capacity>=things[0][i]){
            capacity-=things[0][i];
            counter+=things[1][i];
        //}
    }

    /*for(int i=0; i<N; i++)
        cout << things[0][i] << ": " << things[1][i] << endl;*/

    cout << "Максимальная сумма, которую можно унести: " << counter<< endl;
    return 0;
}
