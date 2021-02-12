//***запись в файл N случайных неповтор€ющихс€ чисел***
#include <fstream>
#include <iostream>
#include <cstdlib>
#include <ctime>
#define N 1000

using namespace std;

void quick(int arr[], int start, int end){
    int mid;
    int f=start, l=end;
    mid=arr[(f+l)/2];               //вычисление опорного элемента
    do{
        while(arr[f]<mid)f++;
        while(arr[l]>mid)l--;
        if(f<=l){                  //перестановка элементов
            swap(arr[f], arr[l]);
            f++;
            l--;
        }
    }while(f<l);
    if(start<l)quick(arr, start, l);
    if(f<end)quick(arr, f, end);
}

int main(){
    srand(time(0));
    int arr[N];
    int bigArr[N*10];
    int pos;
    for(int i=0; i<N*10; i++)       //10 000 неповтор€ющихс€ чисел
        bigArr[i]=i;

    for(int i=0; i<N; i++){     //записыаем в массив с 1000 элементов
        do{
            pos=rand()%(N*10);
        }while(bigArr[pos]<0);
        arr[i]=bigArr[pos];
        bigArr[pos]=-1;
    }

    ofstream fout("3_1.random_numbers.bin");    //записываем в файл
    for(int i=0; i<N; i++){
        fout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            fout << endl;
    }
    fout.close();

    cout << ">>random_numbers - Done!" << endl;

    quick(arr, 0, N-1);        //сортируем
    for(int i=0; i<N; i++)      //сохран€ем
        bigArr[i]=arr[i];
    for(int i=0; i<N; i++)      //обращаем
        arr[i]=bigArr[N-1-i];
    fout.open("3_2.reverse_numbers.bin");       //запись обратно-отсортированных
    for(int i=0; i<N; i++){
        fout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            fout << endl;
    }
    fout.close();

    cout << ">>reverse_numbers - Done!" << endl;

    ifstream fin("3_1.random_numbers.bin");    //считываем случайные числа
    for(int i=0; i<N; i++)
        fin >> arr[i];
    fin.close();

    for(int i=0; i<N; i+=100)           //сортируем по 100 элементов
        quick(arr, i, i+99);


    fout.open("3_3.hundreds_numbers.bin");       //запись отсортированных по 100
    for(int i=0; i<N; i++){
        fout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            fout << endl;
    }
    fout.close();

    cout << ">>hundreds_numbers - Done!" << endl;

    quick(arr, 0, N-1);    //сортируем весь
    swap(arr[0], arr[N-1]);       //мен€ем первый с последним

    fout.open("3_4.mostly_sorted_numbers.bin");       //запись почти отсортированного
    for(int i=0; i<N; i++){
        fout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            fout << endl;
    }
    fout.close();

    cout << ">>mostly_sorted_numbers - Done!" << endl;

    return 0;
}
