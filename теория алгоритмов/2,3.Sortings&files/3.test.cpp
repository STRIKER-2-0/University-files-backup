#include <iostream>
#include <clocale>
#include <cstdlib>
#include <ctime>
#define N 20

using namespace std;

void shaker(int arr[], int start, int end){
    if(end==start+1)
        return;

    for(int i=start; i<end; i++)
        if(arr[i]>arr[i+1])
            swap(arr[i], arr[i+1]);
    end--;
    for(int i=end; i>start; i--)
        if(arr[i-1]>arr[i])
            swap(arr[i-1], arr[i]);
    start++;
    shaker(arr, start, end);
}

void quicksort(int arr[], int start, int end){
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
    if(start<l)quicksort(arr, start, l);
    if(f<end)quicksort(arr, f, end);
}

int main(){
    setlocale(LC_CTYPE, "rus");
    srand(time(0));
    int arr[N];
    for(int i=0; i<N; i++){
        arr[i]=rand()%100;
        cout << arr[i] << " ";
    }
    shaker(arr, 0, N-1);
    cout << endl << endl;
    for(int i=0; i<N; i++)
        cout << arr[i] << " ";


    /*cout << "\n\n";
    for(int i=0; i<N; i++){
        cout << arr[i] << " ";
        if((i%20==0)&&(i>0))
            cout << endl;
    }*/
    return 0;
}
