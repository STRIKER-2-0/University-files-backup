#include <iostream>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

int N;
int* arr;
int* arr2;

void create(){
    srand(time(0));
    cout << "Введите размер массива: ";
    cin >> N;
    arr=(int*)malloc(N*sizeof(int));
    for(int i=0; i<N; ++i)
        arr[i]=rand()%9;
    cout << "Массив создан!!" << endl;
}

void print(){
    cout << "Ваш массив: ";
    for(int i=0; i<N; ++i)
        cout << arr[i] << " ";
}

void addpoint(int x){
    if(x==0)N++;else N--;
    int pos;
    cout << "Введите позицию ячейки: ";
    cin >> pos; pos--;

    arr2=(int*)malloc((N)*sizeof(int));
    for(int i=0; i<pos; ++i)
        arr2[i]=arr[i];
    if(x==0)
        for(int i=pos+1; i<N; ++i)
            arr2[i]=arr[i-1];
    else
        for(int i=pos; i<N; ++i)
            arr2[i]=arr[i+1];

    free(arr);

    arr=(int*)malloc((N)*sizeof(int));

    for(int i=0; i<N; ++i)
        arr[i]=arr2[i];
    free(arr2);

    if(x==0)arr[pos]=0;
    if(x==0)
        cout << "Ячейка добавлена!!";
    else
        cout << "Ячейка удалена!!";
}

void addnumbers(int x){
    int beg,fin;
    cout << "Укажите диапазон значений: с "; cin >> beg; cout << " по "; cin >> fin;
    if(x==0){
        for(int i=beg-1; i<=fin-1; i++)
            arr[i]=0;
        cout << "Значения удалены!" << endl;
    }
    else{
        cout << "Введите значения: ";
        for(int i=beg-1; i<=fin-1; i++)
            cin >> arr[i];
        cout << "Значения добавлены!" << endl;
    }
}

int menu(){

    int ans;
    cout << "\nВыберите действие:\n\t1.Напечатать массив\n\t2.Добавить ячейку\n\t3.Удаление ячейки\n\t4.Удалить диапазон значений из массива\n\t5.Добавить диапазон значений в массив\n\t6.Выход\n";
    cin >> ans;
    switch(ans){
        case 1: print(); break;
        case 2: addpoint(0); break;
        case 3: addpoint(1); break;
        case 4: addnumbers(0); break;
        case 5: addnumbers(1); break;
        case 6: cout << "Удачного дня!!!"; return 0;
        default: cout << "Некорректное значение!!!";
    }
}
int psevdomenu(){
    int ans=0;
    cout << "1.Создать массив\n2.Выход\n";
    cin >> ans;
    switch(ans){
        case 1: create(); return 1;
        case 2: cout << "Удачного дня!!!"; return 0;
        default: cout << "Некорректное значение!!!"; psevdomenu();
    }
}

int main(){
    setlocale(LC_ALL,"russian");
    cout << "\t\t---Программа начала работу---\n";
    if(psevdomenu()==0)return 0;
    while(menu()!=0){}

    free(arr);
    return 0;
}
