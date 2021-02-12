#include <iostream>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

int N,M;
int** arr;
int** arr2;

void create(){ //создание динамической матрицы
    srand(time(0));
    cout << "Введите размер массива: ";
    cin >> N >> M;
    arr=(int**)malloc(N*sizeof(int*));
    for(int i=0; i<N; ++i)
        arr[i]=(int*)malloc(M*sizeof(int));
    for(int i=0; i<N; ++i)
        for(int j=0; j<M; ++j)
            arr[i][j]=rand()%9;
    cout << "Массив создан!!" << endl;
}

void print(){ //печать
    cout << "Ваш массив: " << endl;
    for(int i=0; i<N; ++i){
        cout << "| ";
        for(int j=0; j<M; ++j)
            cout << arr[i][j] << " ";
    cout << "|" << endl;
    }
}

void add_del_line(int x){ //изменение строк
    if(x==0)N++; else N--;          //выбор действия маяком
    int pos;                        //задается позиция для действия
    cout << "Введите номер строки: ";
    cin >> pos; pos--;//перевод в систему от нуля

    arr2=(int**)malloc(N*sizeof(int*));         //создание резервной матрицы
    for(int i=0; i<N; ++i)
        arr2[i]=(int*)malloc(M*sizeof(int));

    for(int i=0; i<pos; ++i)             //элементы до активной позиции(если они присутствуют) просто копируются
        for(int j=0; j<M; ++j)
            arr2[i][j]=arr[i][j];
    if(x==0) //дальше - зависит от выбранного действия
        for(int i=pos+1; i<N; ++i)      //при добавлениии строки перескакиваем через позицию
            for(int j=0; j<M; ++j)
                arr2[i][j]=arr[i-1][j];
    else
        for(int i=pos; i<N; ++i)  //при удалении затираем её
            for(int j=0; j<M; ++j)
                arr2[i][j]=arr[i+1][j];

    if(x==0) for(int i=0; i<N-1; ++i)free(arr[i]); //очистка первого массива(два варианта для действий)
    else for(int i=0; i<N+1; ++i)free(arr[i]);
    free(arr);

    arr=(int**)malloc(N*sizeof(int*));  //перевыделение первого массива уже с новым размером(аналогичным резервному)
    for(int i=0; i<N; ++i)
        arr[i]=(int*)malloc(M*sizeof(int));
    for(int i=0; i<N; ++i)              //передача данных
        for(int j=0; j<M; ++j)
            arr[i][j]=arr2[i][j];

    if(x==0)        //в случае добавления элементы новой строки занулить
        for(int i=0; i<M; ++i)
            arr[pos][i]=0;

    for(int i=0; i<N; ++i)    //очистка резервной матрицы
        free(arr2[i]);
    free(arr2);
    if(x==0) cout << "Строка добавлена!!" << endl;
    else cout << "Строка удалена!!" << endl;
}
void add_del_column(int x){ //изменение столбцов
    if(x==0)M++; else M--;
    int pos;
    cout << "Введите номер столбца: ";
    cin >> pos; pos--;

    arr2=(int**)malloc(N*sizeof(int*));
    for(int i=0; i<N; ++i)
        arr2[i]=(int*)malloc(M*sizeof(int));

    for(int i=0; i<pos; ++i)
        for(int j=0; j<N; ++j)
            arr2[j][i]=arr[j][i];
    if(x==0)
        for(int i=pos+1; i<M; ++i)
            for(int j=0; j<N; ++j)
                arr2[j][i]=arr[j][i-1];
    else
        for(int i=pos; i<M; ++i)
            for(int j=0; j<N; ++j)
                arr2[j][i]=arr[j][i+1];

    for(int i=0; i<N; ++i)free(arr[i]); //сдесь только один вариант
    free(arr);

    arr=(int**)malloc(N*sizeof(int*));
    for(int i=0; i<N; ++i)
        arr[i]=(int*)malloc(M*sizeof(int));
    for(int i=0; i<N; ++i)
        for(int j=0; j<M; ++j)
            arr[i][j]=arr2[i][j];

    if(x==0)
        for(int i=0; i<N; ++i)
            arr[i][pos]=0;

    for(int i=0; i<N; ++i)
        free(arr2[i]);
    free(arr2);
    if(x==0) cout << "Столбец добавлен!!" << endl;
    else cout << "Столбец удалён!!" << endl;
}


int menu(){
    setlocale(LC_ALL,"russian");
    int ans;
    cout << "\nВыберите действие:\n\t1.Напечатать массив\n\t2.Добавить строку\n\t3.Удалить строку\n\t4.Добавить столбец\n\t5.Удалить столбец\n\t6.Выход\n";
    cin >> ans;
    switch(ans){
        case 1: print(); break;
        case 2: add_del_line(0); break;
        case 3: add_del_line(1); break;
        case 4: add_del_column(0); break;
        case 5: add_del_column(1); break;
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

    for(int i=0; i<N; ++i)
        free(arr[i]);
    free(arr);
    return 0;
}
