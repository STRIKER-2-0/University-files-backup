#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>

using namespace std;
int n,m,kol=0;  //задаваемое значение строк
int** arr;  //динамический массив

void create(){ //полное создание дин. массива
    cin >> n;
    arr=(int**)malloc(n*(sizeof(int*)));
    for(int i=0; i<n; ++i)
        arr[i]=(int*)malloc(n*(sizeof(int)));
}

int ans(){  //функция, заполняющая массив и печатающая его
    srand(time(0));
    for(int i=0; i<n; ++i)
        for(int j=0; j<n; ++j)
            arr[i][j]=rand()%20;
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j)
            cout << arr[i][j] << "  ";
        cout << endl;
    }
}



int main(){
    setlocale(LC_CTYPE, "rus");

    cout << "Введите порядок матрицы: ";
    create();
    ans();
    for(int j=0; j<n; ++j){
        m=0;
        for(int i=0; i<n; ++i){

            for(int k=i+1; k<n; ++k)
                if(arr[i][j]==arr[k][j])
                    ++m;

        }
    if(m==0)
        ++kol;

    }
    cout << "Количество столбцов с попарно различными элементами: " << kol;

    for(int i=0; i<n; ++i)  //очистка памяти
        free(arr[i]);
    free(arr);
    return 0;
}
