#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>
#include <cmath>

using namespace std;

const int n=6,m=7;
int arr[n][m];
int mas[m];

int ch(int x){  //чётность
    if(x%2==0)
        return 0;
    else
        return 1;
}

void create(int x,int y,int q){ //заполнение массива
    srand(time(0));
    for(int i=0; i<x; i++)
        for(int j=0; j<y; j++){
            if(q==0)
                arr[i][j]=rand()%9;
            else if(q==1)
                arr[i][j]=ch(arr[i][j]);
            else
                mas[i]=0;
        }
 }

void print(int x,int y){ //печать массива
     for(int i=0; i<x; i++){
        cout << "| ";
        for(int j=0; j<y; j++)
            cout << arr[i][j] <<" ";
        cout << "|" << endl;
    }
 cout << endl;
}

void preob(int x,int y,int q){ //преобразование
    setlocale(LC_CTYPE, "rus");
    cout << "Числа по ";
    if(q==0) cout << "строкам:" << endl;
    else cout << "столбцам:" << endl;

    for(int i=0; i<x; i++){
        for(int j=0; j<y; j++)
            if(q==0)
                mas[i]+=arr[i][j]*pow(2,y-1-j);
            else
                mas[i]+=arr[j][i]*pow(2,y-1-j);
        cout << i+1 << ". " << mas[i] << endl;
    }
    cout << endl;
}

void MAX(int x){  //максимальное значение из выборки
    int lmax=0,res=0;
    for(int i=0; i<x; ++i)
        if(mas[i]>lmax){
            lmax=mas[i];
            res=i+1;
        }
    cout << "Позиция максимального элемента: " << res << endl << endl;
}

int main(){
    setlocale(LC_CTYPE, "rus");

    cout << "Исходный массив:" << endl; create(n,m,0); print(n,m);
    cout << "Преобразованный массив:" << endl; create(n,m,1); print(n,m);

    create(n,m,2); preob(n,m,0); MAX(n);
    create(n,m,2); preob(m,n,1); MAX(m);

    return 0;
}
